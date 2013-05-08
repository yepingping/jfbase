package com.jf.framework.interceptor;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.jf.common.session.SessionConstants;
import com.jf.common.session.SessionUser;

/**
 * @描述:<p>对hibernate的数据库更新，插入操作拦截 </p>
 * 
 * @作者: 叶平平(yepp)
 * 
 * @时间: 2012-1-5 下午10:25:07
 */
@SuppressWarnings("serial")
public class DaoInterceptor extends EmptyInterceptor implements Serializable {
	protected static final Logger logger = Logger.getLogger(DaoInterceptor.class);

	/**
	 * 构造方法
	 */
	public DaoInterceptor() {
		// TODO Auto-generated constructor stub
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		if (logger.isDebugEnabled()) {
			logger.debug(" >>>>>> onFlushDirty 处理：" + SessionUser.getMapVar());
		}
		return setState(currentState, propertyNames);
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		if (logger.isDebugEnabled()) {
			logger.debug(" >>>>>> onSave 处理：" + SessionUser.getMapVar());
		}
		return setState(state, propertyNames);

	}

	/*
	 * public boolean onLoad(Object entity, Serializable id, Object[] state,
	 * String[] propertyNames, Type[] types) { if(logger.isDebugEnabled()){
	 * logger.debug(" >>>>>> onLoad 处理：" + SessionUser.getMapVar()); } return
	 * setState(state, propertyNames); }
	 */
	/**
	 * 功能描述：
	 * 
	 * @author 叶平平(ypp)
	 *         <p>
	 *         创建日期 ：2012-1-6 下午12:49:03
	 *         </p>
	 * 
	 * @param state
	 *            model的值
	 * @param propertyNames
	 *            model的属性列表
	 * @return
	 * 
	 *         <p>
	 *         修改历史 ：(修改人，修改时间，修改原因/内容)
	 *         </p>
	 */
	private boolean setState(Object[] state, String[] propertyNames) {
		boolean ret = false;
		for (int i = 0; i < propertyNames.length; i++) {
			// creator crDate crUnit moDate modificator moUnit
			if (setStateValue(state, propertyNames, i, "crUserId", SessionUser.get(SessionConstants.USER_ID.getValue()), false)
					|| setStateValue(state, propertyNames, i, "crDate",new java.util.Date(), false)
					|| setStateValue(state, propertyNames, i, "crDeptId",SessionUser.get(SessionConstants.DEPT_ID.getValue()),false)
					|| setStateValue(state, propertyNames, i, "crCompanyId",SessionUser.get(SessionConstants.DEPT_ID.getValue()),false)) {
				ret = true;
			}

			if (setStateValue(state, propertyNames, i, "moUserId",SessionUser.get(SessionConstants.USER_ID.getValue()), true)
					|| setStateValue(state, propertyNames, i, "moDate",new java.util.Date(), true)
					|| setStateValue(state, propertyNames, i, "moDeptId",SessionUser.get(SessionConstants.DEPT_ID.getValue()),true)
					|| setStateValue(state, propertyNames, i, "moCompanyId",SessionUser.get(SessionConstants.DEPT_ID.getValue()),true)) {
				ret = true;
			}

		}
		return ret;
	}

	/**
	 * 功能描述：
	 * 
	 * @author 叶平平(ypp)
	 *         <p>
	 *         创建日期 ：2012-1-6 下午12:49:48
	 *         </p>
	 * 
	 * @param state
	 * @param propertyNames
	 * @param idx
	 * @param propStr
	 * @param newValue
	 * @param force
	 *            是否强制赋值，对于create信息，如果有，就不赋值，对于modify信息，每次都强制赋值
	 * @return
	 * 
	 *         <p>
	 *         修改历史 ：(修改人，修改时间，修改原因/内容)
	 *         </p>
	 */
	private boolean setStateValue(Object[] state, String[] propertyNames,
			int idx, String propStr, Object newValue, boolean force) {

		boolean ret = false;
		if (propertyNames[idx].equalsIgnoreCase(propStr)) {
			if (force) {// 强制赋值
				state[idx] = newValue;
				ret = true;
			} else {// 如果原来有值，就不赋值，没有值才赋值
				if (null == state[idx]) {
					state[idx] = newValue;
				}
			}
		}
		return ret;
	}
}
