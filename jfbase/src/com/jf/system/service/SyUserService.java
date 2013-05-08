package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyUser;

/**
 * @描述:<p>用户Service接口 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:06:38
 */
public interface SyUserService extends BaseService{

	/**
	 * @描述:<p> 保存用户 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:06:24
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syUser
	 * @return
	 */
	public SyUser saveSyUser(SyUser syUser);
}
