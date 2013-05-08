package com.jf.system.dao;

import com.jf.framework.dao.BaseDao;
import com.jf.system.model.SyUser;

/**
 * @描述:<p>用户Dao接口 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午12:00:52
 */
public interface SyUserDao extends BaseDao<SyUser>{
	
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
	public SyUser saveSyUser(SyUser syUser);
}
