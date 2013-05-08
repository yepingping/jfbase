package com.jf.framework.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.jf.common.page.PageModel;
import com.jf.common.utils.CollectionUtils;
import com.jf.common.utils.PropertiesUtil;
import com.jf.common.utils.StringUtil;
import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>Spring JDBC 操作封装</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-4-8 上午12:08:34
 */

public class DaoJdbcBase extends JdbcDaoSupport {
	private Log log = LogFactory.getLog(this.getClass());
	private String dbType = null;
	/**
	 * 保存、更新、删除一个实体
	 * @param sql
	 * @param objectArray
	 * @param intArray
	 */
	public void saveOrUpdate(String sql, Object[] objectArray, int[] intArray) {
		getJdbcTemplate().update(sql, objectArray, intArray);
		/**
		 * 1.删除
		 * getJdbcTemplate().update("delete from module where ids=?", new Object[]{personid},new int[]{java.sql.Types.BIGINT});
		 * 2.保存
		 * getJdbcTemplate().update("insert into module(name) values(?)", new Object[]{module.getNames()}, new int[]{java.sql.Types.VARCHAR});
		 * 3.更新
		 * getJdbcTemplate().update("update set module name=? where ids=?", new Object[]{module.getNames(), module.getIds()}, new int[]{java.sql.Types.VARCHAR,java.sql.Types.BIGINT});
		 */
	}
	/**
	 * 查询单个实体
	 * @param <T>
	 * @param sql
	 * @param objectArray
	 * @param intArray
	 * @param classFullName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> T getOneEntity(String sql, Object[] objectArray, int[] intArray, String classFullName) {
		T entity = null;;
		try {
			//Module person=(Module) getJdbcTemplate().queryForObject("select * from module where ids=?", new Object[]{moduleIds}, new int[]{java.sql.Types.BIGINT},new ModuleResultSetMap());
			entity = (T) getJdbcTemplate().queryForObject(sql, objectArray, intArray, (RowMapper) Class.forName(classFullName).newInstance());
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	/**
	 * 查询多个对象
	 * @param <T>
	 * @param sql
	 * @param classFullName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> List<T> getManyEntity(String sql, String classFullName) {
		List<T> list = null;
		try {
			//return (List<Module>)( getJdbcTemplate().query("select * from module", new ModuleResultSetMap()));
			list =  (List<T>)( getJdbcTemplate().query(sql, (RowMapper) Class.forName(classFullName).newInstance()));
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:41:09
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> List queryForList(String sql){
		List list = getJdbcTemplate().queryForList(sql);
		return list;
	}
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:41:07
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> List queryForList(String sql, int size){
		List list = null;
		if(size > 0){
			getJdbcTemplate().setMaxRows(size);
		}
		list = getJdbcTemplate().queryForList(sql);
		getJdbcTemplate().setMaxRows(10000);
		return list;
	}
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:41:04
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> List queryForList(String sql,Object obj[]){
		List list = getJdbcTemplate().queryForList(sql, obj);
		return list;
	}
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:41:01
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @param obj
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> List queryForList(String sql,Object obj[],int size){
		List list = null;
		if(size > 0){
			getJdbcTemplate().setMaxRows(size);
		}
		list = getJdbcTemplate().queryForList(sql,obj);
		getJdbcTemplate().setMaxRows(10000);
		return list;
	}
	
	
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:40:58
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> Map queryForMap(String sql){
		Map map = getJdbcTemplate().queryForMap(sql);
		return map;
	}
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:40:56
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> Map queryForMap(String sql,Object obj[]){
		Map map = getJdbcTemplate().queryForMap(sql,obj);
		return map;
	}
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:40:50
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @param clzz
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> Object queryForObject(String sql, Class clazz, Object obj[]){
		return  getJdbcTemplate().queryForObject(sql, obj, clazz);
	}
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-10 下午08:40:38
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql
	 * @return
	 */
	public String getCountSql(String sql){
		StringBuilder sb = new StringBuilder();
		sb.append(" select count(*) as count from (");
		sb.append(sql);
		sb.append(" ) xCount ");
		return sb.toString();
	}
	/**
	 * @描述:<p>获取数据库类型</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-2-25 下午04:30:05
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @return
	 */
	private String getDefaultDBType(){
		String dbType = PropertiesUtil.getValue("/sysConfig.properties", "system.db.type");
		if(StringUtil.isEmpty(dbType)){
			dbType="MySQL";
		}
		return dbType;
	}
	/**
	 * @描述:<p>分页查询sql  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-2-25 下午04:39:45
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql		SQL
	 * @param startIndex	起始索引
	 * @param pageSize		分页大小
	 * @return
	 */
	private String getPageSql(String sql,int startIndex, int pageSize){
		String dbType = this.getDbType();
		return this.getPageSql(sql,dbType, startIndex, pageSize);
	}
	/**
	 * @描述:<p>分页查询sql </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-2-25 下午04:39:49
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql		SQL
	 * @param dbType	数据库类型
	 * @param start		起始索引
	 * @param pageSize		分页大小
	 * @return
	 */
	private String getPageSql(String sql,String dbType,int startIndex,int pageSize){
		String pageSql = "";
		if(dbType.equals("MySQL")){
			pageSql = this.getMySQLPageSQL(sql, startIndex, pageSize);
		}
		else if(dbType.equals("Oracle")){
			pageSql = this.getOraclePageSQL(sql, startIndex, pageSize);
		}
		return pageSql;
	}
	/**
	 * @描述:<p> 构造MySql分页sql </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-2-25 下午04:48:16
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	private String getMySQLPageSQL(String sql, int startIndex, int pageSize){
		String result = "";
		if(!StringUtil.isNullOrEmpty(startIndex) && !StringUtil.isNullOrEmpty(pageSize)){
			result = sql + " limit " + startIndex + " , " + pageSize;
		}else if(!StringUtil.isNullOrEmpty(startIndex) && StringUtil.isNullOrEmpty(pageSize)){
			result = sql + " limit " + startIndex;
		}else{
			result = sql;
		}
		return result;
	}
	
	/**
	 * @描述:<p>构造Oracle分页sql  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-2-25 下午05:17:05
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	private String getOraclePageSQL(String sql, int startIndex, int pageSize){
		if(StringUtil.isEmpty(sql)){
			return null;
		} 
		int endIndex = startIndex + pageSize;
		String result = "select * from (select rOraclePageSQL.*,ROWNUM as currentRow from (" +  
		                 sql + ") rOraclePageSQL where rownum <" + endIndex + ") where currentRow>" + startIndex;
		return result;
	}
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-2-25 下午05:17:32
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @param startIndex
	 * @param pageSize
	 * @param obj
	 * @return
	 */
	public <T extends EntityBase> PageModel<T> queryBySql(String sql, int startIndex, int pageSize,Object obj[]){
		return this.queryBySql(sql,null, startIndex, pageSize,obj);
	}
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-2-25 下午05:17:48
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param sql
	 * @param countSql
	 * @param startIndex
	 * @param pageSize
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> PageModel<T> queryBySql(String sql,String countSql, int startIndex, int pageSize,Object obj[]){
		PageModel page = new PageModel();
		if(StringUtil.isNullOrEmpty(countSql)){
			countSql = this.getCountSql(sql);
		}
		String pageSql = sql;
		if(!StringUtil.isNullOrEmpty(startIndex) && !StringUtil.isNullOrEmpty(pageSize)){
			pageSql = this.getPageSql(sql, startIndex, pageSize);
		}
		int count = this.getCount(countSql, obj);
		List list = this.getJdbcTemplate().query(pageSql, obj, new ColumnMapRowMapper());
		page.setTotalRows(count);
		page.setResult(list);
		return page;
	}
	@SuppressWarnings("unchecked")
	public <T extends EntityBase> PageModel<T> queryBySqlWithoutCountResult(String sql, int startIndex, int pageSize,Object obj[]){
		PageModel page = new PageModel();
		List list = this.getJdbcTemplate().query(sql, obj,new ColumnMapRowMapper());
		int count = 0;
		if(CollectionUtils.listIsNullOrEmpty(list)){
			count = list.size();
		}
		page.setTotalRows(count);
		page.setResult(list);
		return page;
	}
	public int getCount(String sql, Object obj[]){
		int count = this.getJdbcTemplate().queryForInt(sql, obj);
		return count;
	}
	public String getDbType() {
		if(StringUtil.isEmpty(dbType)){
			dbType = this.getDefaultDBType();
		}
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	/***
	 * http://nvry.iteye.com/blog/856703
	 * */
}
