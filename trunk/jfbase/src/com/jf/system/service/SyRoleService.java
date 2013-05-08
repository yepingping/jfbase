package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyRole;

/**
 * @描述:<p>角色Service接口</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:39:33
 */
public interface SyRoleService extends BaseService{

	/**
	 * @描述:<p>保存角色</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:41:47
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syRole
	 * @return
	 */
	public SyRole saveSyRole(SyRole syRole);
}
