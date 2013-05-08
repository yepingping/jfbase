package com.jf.framework.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;

import com.jf.common.page.PageModel;

/**
 * @描述:<p> dao接口，定义各个业务对象数据库访问接口的公用方法 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-11-12 上午10:07:03
 * @param <T>
 */
@SuppressWarnings("unchecked")
public interface BaseDao<T> {
	/**
	 * @描述:<p>新增对象</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-12 上午10:28:00
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param entity 实体对象
	 * @return
	 */
	public T save(T entity);
	
	/**
	 * @描述:<p>新增或更新对象</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-12 上午10:31:55
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param entity
	 * @return
	 */
	public T saveOrUpdate(T entity);
	
	/**
	 * @描述:<p>删除对象</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-12 上午10:57:22
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param entity
	 * @return
	 */
	public T delete(T entity);
	
	
	/**
	 * @描述:<p>更新    仅修改基本字段</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-19 上午11:16:22
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param entity
	 */
	public void updateBasicField(T entity);
	
	/**
	 * @描述:<p>更新  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-19 上午11:17:08
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * @描述:<p>刷新缓存,实现数据库数据与对象同步  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-16 下午09:36:11
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 */
	public void flush();
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-16 下午09:39:46
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param entity
	 * @param lockMode
	 */
	public void lock(Object entity, LockMode lockMode);
	
	/**
	 * @描述:<p>清空缓存  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午12:04:39
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 */
	public void clear();
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午12:13:26
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql SQL
	 * @return
	 */
	public List<T> queryForList(String sql);
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午12:10:49
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql	SQL
	 * @param size	数据集大小
	 * @return
	 */
	public List<T> queryForList(String sql, int size);
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午12:15:19
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql 	SQL语句
	 * @param list 	参数
	 * @return
	 */
	public List<T> queryForList(String sql, List list);
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午12:16:41
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql 	SQL语句
	 * @param list 	参数
	 * @param size	数据集大小
	 * @return
	 */
	public List<T> queryForList(String sql, List list, int size);
	
	/**
	 * @描述:<p>用于返回单行记录  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午12:19:50
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql (用?占位符)
	 * @return
	 */
	public Map queryForMap(String sql);
	
	/**
	 * @描述:<p>用于返回单行记录  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午12:21:28
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql	(用?占位符)
	 * @param list	参数集
	 * @return
	 */
	public Map queryForMap(String sql, List list);
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午01:02:41
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql	(用?占位符)
	 * @param list	参数集
	 * @param clazz	返回的类型
	 * @return
	 */
	public T queryForObject(String sql, List list, Class<T> clazz);
	/**
	 * @描述:<p>返回一个对象
	 * 	用法如：可用于登录验证时，根据用户名、密码等信息查询用户 
	 *  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午04:28:02
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param hql	查询HQL语句
	 * @param params	参数集
	 * @return		唯一实体，返回null则表示不存在配置的实体
	 * 
	 */
	public T findObject(String hql, List params);
	
	/**
	 * @描述:<p>根据属性值查询实体是否存在</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午04:45:25
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param clazz			实体类名
	 * @param propertyName	参照的属性名
	 * @param propertyValue	属性值
	 * @return				存在则返回true,不存在则返回false
	 */
	public boolean isPropertyExist(Class<T> clazz, String propertyName,Object propertyValue);
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-27 下午05:54:04
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param hql
	 * @param values
	 * @return
	 */
	public List findList(String hql,Object values[]);
	
	/**
	 * @描述:<p>拼装总记录数的sql  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午01:00:28
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql
	 * @return
	 */
	public String getCountSql(String sql);
	/**
	 * @描述:<p>HQL分页查询  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-11-27 下午05:54:08
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param hql		查询语句hql语句
	 * @param start 	开始记录号
	 * @param end		最大记录数
	 * @return
	 */
	public PageModel<T> findByHql(String hql , int start ,int end);
	/**
	 * @描述:<p>HQL分页查询  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午02:04:08
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param hql		 查询语句,支持连接查询和多条件查询
	 * @param start		开始记录号
	 * @param end		最大记录数
	 * @param params	参数数组,代替hql中的"?"号
	 * @return			封装List和total的PageModel对象
	 */
	public PageModel<T> findlHql(String hql , int start ,int end, List list);
	/**
	 * @描述:<p>SQL分页查询  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午01:29:46
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql	 查询SQL语句
	 * @param strat	开始记录号
	 * @param end	最大记录数
	 * @return		封装List和total的PageModel对象
	 */
	public PageModel queryBySql(String sql,int strat, int end);
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午02:22:44
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param sql	 查询SQL语句
	 * @param strat	开始记录号
	 * @param end	最大记录数
	 * @param list	参数集
	 * @return		封装List和total的PageModel对象
	 */
	public PageModel queryBySql(String sql, int strat,int end, List list);
}
