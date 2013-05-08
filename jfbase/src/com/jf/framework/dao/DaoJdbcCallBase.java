package com.jf.framework.dao;

import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.jf.common.utils.StringUtil;

/**
 * 功能描述：Spring 存储过程  操作封装
 *
 * @author  叶平平(ypp)
 *
 * <p>修改历史：(修改人，修改时间，修改原因/内容)</p>
 */
@SuppressWarnings("unchecked")
public class DaoJdbcCallBase {
	//保存 procedure的参数定义
	private static Map<String, SqlParameter[]> proceduceMap = new HashMap<String, SqlParameter[]>();
	
	@Autowired
	@Qualifier("jdbcTemplate")
	protected JdbcTemplate jdbcTemplate;
	
	protected SimpleJdbcCall getCaller() {
		return new SimpleJdbcCall(jdbcTemplate);
	}
	public Map executeProcedure(String procedureName) {
		return executeProcedure(null, procedureName);
	}

	public Map executeProcedure(String packageName, String procedureName) {
		return executeProcedure(packageName, procedureName, null);
	}

	public Map executeProcedure(String procedureName, Map params) {
		return executeProcedure(null, procedureName, params);
	}


	public Map executeProcedure(String packageName, String procedureName,
			Map params) {
		return executeProcedure(packageName, procedureName, params, null);
	}
	/**
	 * 功能描述：调用存储过程
	 *
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-2-10 下午03:42:15</p>
	 *
	 * @param packageName     包名 
	 * @param procedureName   过程名
	 * @param params         参数值
	 * @param paramTypes     参数类型
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public Map executeProcedure(String packageName, String procedureName,
			Map params, SqlParameter[] paramTypes) {
		
		if (procedureName == null) {
			throw new InvalidParameterException("存储过程名不能为空！");
		}
		packageName = StringUtil.null2Str(packageName);
		boolean nodefineparam = (paramTypes==null);
		String key = packageName+"."+procedureName;
		if(nodefineparam){
			if(!proceduceMap.containsKey(key)){
				try {
					SqlParameter[] paramDef = getProcedureParams(packageName,procedureName);
					proceduceMap.put(key, paramDef);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			paramTypes = proceduceMap.get(key);
		}
		SimpleJdbcCall call = getCaller();
		if (packageName != null)
			call.withCatalogName(packageName);

		call.withProcedureName(procedureName);
		if (paramTypes != null)
			call.withoutProcedureColumnMetaDataAccess().declareParameters(
					paramTypes);

		if (params == null)
			return call.execute();
		return call.execute(nodefineparam?toMatchParamsDef(params,key):params);
	}
	
	/**
	 * 功能描述：使参数值匹配参数类型 区分大小写
	 *
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-2-10 下午03:42:31</p>
	 *
	 * @param map
	 * @param procedurekey
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	private Map<String,Object>  toMatchParamsDef(Map<String,Object> map,String procedurekey){
		Map<String,Object> newmap = new HashMap<String,Object>();
		Iterator<Entry<String,Object>> it = map.entrySet().iterator();
		SqlParameter[] paramDef = proceduceMap.get(procedurekey);
		while(it.hasNext()){
			Entry<String,Object> en = it.next();
			String key = en.getKey();
			String newkey = getInParamTypeName(key,paramDef);
			if(newkey!=null){
				newmap.put(newkey, en.getValue());
			}else{
				newmap.put(key, en.getValue());
			}
		}
		return newmap;
	}
	
	private String  getInParamTypeName(String key,SqlParameter[] paramTypes){
		for (SqlParameter sqlParameter : paramTypes) {
			if(key.equalsIgnoreCase(sqlParameter.getName())){
				return sqlParameter.getName();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private Map<String,Object> toUpperMapKey(Map<String,Object> map){
		Map<String,Object> newmap = new HashMap<String,Object>();
		Iterator<Entry<String,Object>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,Object> en = it.next();
			newmap.put(en.getKey().toUpperCase(), en.getValue());
		}
		return newmap;
	}
	
	private SqlParameter[] getProcedureParams(String packageName, String procedureName) throws SQLException{
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		DatabaseMetaData dmd = connection.getMetaData();
	    ResultSet rs =  dmd.getProcedureColumns(packageName, dmd.getUserName(), procedureName, "%");
	    List<SqlParameter> sqlparamls = new ArrayList<SqlParameter>();
	    while(rs.next()){
	    	SqlParameter parameter =null;
	    	int dataType = rs.getInt("DATA_TYPE");
	    	//其他类型都当成字符串 具体遇到再处理
	    	if(dataType== Types.OTHER){
	    		dataType = Types.VARCHAR;
	    	}
	    	if(rs.getInt(5)==4){
	    	  parameter = new SqlOutParameter(rs.getString("COLUMN_NAME"), dataType);
	    	}else{
	    		parameter = new SqlParameter(rs.getString("COLUMN_NAME"), dataType);
	    	}
	    	sqlparamls.add(parameter);
	    }
		return sqlparamls.toArray(new SqlParameter[sqlparamls.size()]);
	}
}
