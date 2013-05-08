package com.jf.framework.dao;


import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jf.common.page.PageModel;
import com.jf.common.utils.ReflectionUtil;
import com.jf.common.utils.StringUtil;
import com.jf.framework.entity.base.EntityBase;


/**
 * @描述:<p>Spring Hibernate 操作封装 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-6-19 上午10:59:46
 */
@SuppressWarnings("unchecked")
public class DaoHibernateBase<T> extends HibernateDaoSupport {

	public DaoHibernateBase() {
		
	}
	/**
	 * 获取一个对象
	 * @param <T>
	 * @param entityClass 对象类
	 * @param ids
	 * @return
	 */
	@SuppressWarnings("hiding")
	public <T extends EntityBase> T findOneEntity(Class<T> entityClass, Long ids) throws Exception {	
		return (T) getHibernateTemplate().get(entityClass, ids);
	}
	/**
	 * @描述:<p>通过Id获取一个实体对象  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午04:14:37
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param entityClass 对象类
	 * @param ids		id
	 * @return
	 * @throws Exception
	 */
	private T get(Class<T> entityClass, Serializable ids) throws Exception {	
		return  (T) getHibernateTemplate().get(entityClass, ids);
	}
	
	/**
	 * 获取一个对象
	 * @param <T>
	 * @param entityClass 对象类
	 * @param filterString 过滤HQL
	 * @return
	 * @throws Exception
	 */
	public <T extends EntityBase> T findOneEntity(Class<T> entityClass,
			String filterString) throws Exception {	
		Query query = this.getSession().createQuery("from " + entityClass.getName() + filterString);
		return (T) query.uniqueResult();
	}
	/**
	 * @描述:<p>获取一个对象 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午04:24:46
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param hql	查询HQL语句
	 * @param list	参数集
	 * @return		唯一实体，返回null则表示不存在配置的实体
	 * @exception	如果查询的结果集不唯一,则抛异常
	 */
	public <T extends EntityBase> T findOneEntity(final String hql, final List params ){
		 return (T)getHibernateTemplate().execute(new HibernateCallback(){
			 public Object doInHibernate(Session session) throws HibernateException,SQLException{
				 Query query = session.createQuery(hql);
				 if(!StringUtil.isNullOrEmpty(params)){
						for(int i=0; i<params.size(); i++){
							Object param = params.get(i);
							if(param instanceof Integer){
								query.setInteger(i,(Integer)(params.get(i)));
							}
							if(param instanceof String){
								query.setString(i,(String)params.get(i));
							}
							if(param instanceof Long){
								query.setLong(i,(Long)params.get(i));
							}
							if(param instanceof Double){
								query.setDouble(i, (Double)params.get(i));
							}
							if(param instanceof BigDecimal){
								query.setBigDecimal(i, (BigDecimal)params.get(i));
							}
							if(param instanceof Boolean){
								query.setBoolean(i, (Boolean)params.get(i));
							}
							if(param instanceof Float){
								query.setFloat(i, (Float)params.get(i));
							}
							if(param instanceof Date){
								query.setDate(i, (Date)params.get(i));
							}
						}
					}
				 return (T)query.uniqueResult();
			 }
		 });
	}
	
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
	 * @param value			 属性值
	 * @return				存在则返回true,不存在则返回false
	 */
	public boolean isPropertyExist(final Class<T> clazz, final String propertyName, final Object value){
		return (Boolean)getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria = session.createCriteria(clazz);
				criteria.add(Restrictions.eq(propertyName, value));
				return !criteria.list().isEmpty();
			}
		});
	}
	/**
	 * 获取多个对象
	 * @param <T>
	 * @param entityClass 对象类
	 * @param filterString 过滤HQL
	 * @return
	 * @throws Exception
	 */
	public <T extends EntityBase> List<T> findManyEntity(
			Class<T> entityClass, String filterString) throws Exception {
		Query query = this.getSession().createQuery("from "+entityClass.getName()+filterString);
		List<T> list = query.list();
		return list;
	}
	/**
	 * 获取多个对象
	 * @param <T>
	 * @param entityClass 对象类
	 * @param filterString 过滤HQL
	 * @param orderByString 排序
	 * @return
	 * @throws Exception
	 */
	public <T extends EntityBase> List<T> findManyEntityByOrder(Class<T> entityClass, String filterString, String orderByString)
			throws Exception {
		Query query = this.getSession().createQuery("from " + entityClass.getName() + filterString + orderByString);
		List<T> list = query.list();
		return list;
	}
	
	/**
	 * @描述:<p>  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午04:56:01
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param clazz			实体类名
	 * @param propertyName	排序的参照属性
	 * @param order			排序方式,true表示升序,false表示降序,当propertyName赋值为null时,此参数无效
	 * @param start			开始记录序号
	 * @param end			最大记录数
	 * @param criterion		查询条件,可有0项或任意多项目
	 * @return				记录List集
	 */
	/*public <T extends EntityBase> List<T> findManyEntityByOrder(final Class<T> clazz,final String propertyName,final boolean order, final int start, final int end, final Criterion criterions){
		return (List<T>)getHibernateTemplate().execute(new HibernateCallback() {	
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria = session.createCriteria(clazz);
				 //按属性条件查询
				for(Criterion criterion :criterions){
					criteria.add(criterion);
				}
				//按某个属性排序
				if(!StringUtil.isNullOrEmpty(propertyName)){
					if(order){
						criteria.addOrder(Order.asc(propertyName));
					}else{
						criteria.addOrder(Order.desc(propertyName));
					}
				}
				 //用于分页查询
				if(end !=0){
					criteria.setFirstResult(start);
					criteria.setMaxResults(end);
				}
				List<T> list = criteria.list();
				return list;
			}
		});
	}*/
	/**
	 * @描述:<p> HQL分页查询 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-13 下午08:46:21
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param <T>
	 * @param hql		 查询语句,支持连接查询和多条件查询
	 * @param start		开始记录号
	 * @param end		最大记录数
	 * @return			封装List和total的PageModel对象
	 */
	public <T extends EntityBase> PageModel<T> findByHql(final String hql , final int start , final int end){
		return (PageModel<T>)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				PageModel<T> pageModel = new PageModel<T>();
				String countQueryString = " select count (*)" + removeSelect(removeOrders(hql));
				Query query = session.createQuery(hql);
				query.setFirstResult(start);
				query.setMaxResults(end);
				pageModel.setResult(query.list());
				pageModel.setTotalRows(getCount(session, countQueryString));
				return pageModel;
			}
			private long getCount(Session session,String countQueryString){
				Long count = 0l;
				Query query = session.createQuery(countQueryString);
				List list= query.list();
				if(list != null && list.size() ==1){
					count = (Long)list.get(0);
					return count;
				}
				return count;
			}
		});	
	}
	
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
	public <T extends EntityBase> PageModel<T> findByHql(final String hql, final int start, final int end, final List params){
		return (PageModel<T>)this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				PageModel<T> pageModel = new PageModel<T>();
				String countQueryString = " select count (*)" + removeSelect(removeOrders(hql));
				Query query = session.createQuery(hql);
				if(!StringUtil.isNullOrEmpty(params)){
					for(int i=0; i<params.size(); i++){
						Object param = params.get(i);
						if(param instanceof Integer){
							query.setInteger(i,(Integer)(params.get(i)));
						}
						if(param instanceof String){
							query.setString(i,(String)params.get(i));
						}
						if(param instanceof Long){
							query.setLong(i,(Long)params.get(i));
						}
						if(param instanceof Double){
							query.setDouble(i, (Double)params.get(i));
						}
						if(param instanceof BigDecimal){
							query.setBigDecimal(i, (BigDecimal)params.get(i));
						}
						if(param instanceof Boolean){
							query.setBoolean(i, (Boolean)params.get(i));
						}
						if(param instanceof Float){
							query.setFloat(i, (Float)params.get(i));
						}
						if(param instanceof Date){
							query.setDate(i, (Date)params.get(i));
						}
					}
				}
				query.setFirstResult(start);
				query.setMaxResults(end);
				pageModel.setResult(query.list());
				pageModel.setTotalRows(getCount(session, countQueryString, params));
				return pageModel;
			}
			private long getCount(Session session,String countQueryString, List params){
				Long count = 0l;
				Query query =   session.createQuery(countQueryString);
				if(!StringUtil.isNullOrEmpty(params)){
					for(int i=0; i<params.size(); i++){
						Object param = params.get(i);
						if(param instanceof Integer){
							query.setInteger(i,(Integer)(params.get(i)));
						}
						if(param instanceof String){
							query.setString(i,(String)params.get(i));
						}
						if(param instanceof Long){
							query.setLong(i,(Long)params.get(i));
						}
						if(param instanceof Double){
							query.setDouble(i, (Double)params.get(i));
						}
						if(param instanceof BigDecimal){
							query.setBigDecimal(i, (BigDecimal)params.get(i));
						}
						if(param instanceof Boolean){
							query.setBoolean(i, (Boolean)params.get(i));
						}
						if(param instanceof Float){
							query.setFloat(i, (Float)params.get(i));
						}
						if(param instanceof Date){
							query.setDate(i, (Date)params.get(i));
						}
					}
				}
				List list= query.list();
				if(list != null && list.size() ==1){
					count = (Long)list.get(0);
					return count;
				}
				return count;
			}
		});
	}

	/**
	 * @描述:<p>处理 hql  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-6-24 上午12:27:20
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param hql
	 * @return
	 */
	private static String removeSelect(String hql){
		int beginPos = hql.toLowerCase().indexOf("from");
		return hql.substring(beginPos);
	}
	/**
	 * @描述:<p>处理hql  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2011-6-24 上午12:25:19
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param hql
	 * @return
	 */
	private static String removeOrders(String hql){
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		while(m.find()){
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	public int getCountByHQL(String hql, Object parameters[])
    {
        int count = 0;
        String countPrefix = "select count(*) ";
        String regex = "\\s*select count\\(.*\\) .*";
        if(!hql.matches("\\s*select count\\(.*\\) .*"))
            hql = (new StringBuilder()).append("select count(*) ").append(hql).toString();
        List result = getHibernateTemplate().find(hql, parameters);
        if(result != null && !result.isEmpty())
            count = Integer.valueOf((new StringBuilder()).append(result.get(0)).append("").toString()).intValue();
        return count;
    }
	

	/**
	 * @描述:<p>更新</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-13 下午08:47:25
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param newInstance
	 */
	public void updateBasicField(T newInstance){
		Class cls = newInstance.getClass();
		Method methods[] = cls.getMethods();
		String methodName = "";
		for(int i=0; i< methods.length; i++){
			Object obj = methods[i].getAnnotation(javax.persistence.Id.class);
			if(null != obj){
				methodName = methods[i].getName();
			}
		}
		if(StringUtil.isEmpty(methodName)){
			methodName =  "getId";
		}
		try {
			Method methodGet = cls.getMethod(methodName,  new Class[] {});
			Serializable value = (String)methodGet.invoke(newInstance,  new Class[] {});			
			T getObject = get(cls,value);			
			//属性copy  copyProperties(newInstance, getObject)
			ReflectionUtil.copyProperties(newInstance, getObject);
			//更新操作 update(getObject);
			this.getHibernateTemplate().update(getObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
