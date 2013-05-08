package com.jf.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.jf.framework.dao.BaseDaoImpl;
import com.jf.system.dao.SyUserDao;
import com.jf.system.model.SyUser;

/**
 * @描述:<p>用户Dao实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 上午11:58:57
 */
@Repository("syUserDao")
public class SyUserDaoImpl  extends BaseDaoImpl<SyUser> implements SyUserDao{

	/**
	 * 构造方法
	 */
	public SyUserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @描述:<p>保存用户  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 上午11:56:46
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syUser
	 * @return
	 */
	public SyUser saveSyUser(SyUser syUser){
		return null;
	}
}
