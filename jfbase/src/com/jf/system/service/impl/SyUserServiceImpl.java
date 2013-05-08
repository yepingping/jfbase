package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyUserDao;
import com.jf.system.model.SyUser;
import com.jf.system.service.SyUserService;


/**
 * @描述:<p> </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:04:19
 */
@Service("syUserService")
public class SyUserServiceImpl extends BaseServiceImpl implements SyUserService{
	
	@Autowired
	@Resource(name="syUserDao")
	private SyUserDao syUserDao;
	/**
	 * 构造方法
	 */
	public SyUserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
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
	public SyUser saveSyUser(SyUser syUser){
		this.syUserDao.saveSyUser(syUser);
		return syUser;
	}
}
