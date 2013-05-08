package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyRoleDao;
import com.jf.system.model.SyRole;
import com.jf.system.service.SyRoleService;

/**
 * @描述:<p>角色Service实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午2:10:47
 */
@Service("syRoleService")
public class SyRoleServiceImpl extends BaseServiceImpl implements SyRoleService{
	@Autowired
	@Resource(name = "syRoleDao")
	private SyRoleDao syRoleDao;
	/**
	 * 构造方法
	 */
	public SyRoleServiceImpl() {
		// TODO Auto-generated constructor stub
	}
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
	public SyRole saveSyRole(SyRole syRole){
		return null;
	}
}
