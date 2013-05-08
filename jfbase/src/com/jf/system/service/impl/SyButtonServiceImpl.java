package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyButtonDao;
import com.jf.system.model.SyButton;
import com.jf.system.service.SyButtonService;

/**
 * @描述:<p> 功能按钮Service实现类</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:54:56
 */
@Service("syButtonService")
public class SyButtonServiceImpl extends BaseServiceImpl implements SyButtonService{
	
	@Autowired
	@Resource(name="syButtonDao")
	private SyButtonDao syButtonDao;
	/**
	 * 构造方法
	 */
	public SyButtonServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @描述:<p>保存功能按钮</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:41:07
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syUser
	 * @return
	 */
	public SyButton saveSyButton(SyButton syButton){
		return null;
	}
}
