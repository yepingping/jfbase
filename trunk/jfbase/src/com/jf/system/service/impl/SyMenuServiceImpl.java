package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyMenuDao;
import com.jf.system.model.SyMenu;
import com.jf.system.service.SyMenuService;

/**
 * @描述:<p>功能 菜单Service实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午2:06:12
 */
@Service("syMenuService")
public class SyMenuServiceImpl  extends BaseServiceImpl implements SyMenuService{
	@Autowired
	@Resource(name = "syMenuDao")
	private SyMenuDao syMenuDao;
	/**
	 * 构造方法
	 */
	public SyMenuServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @描述:<p> 保存功能 菜单</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:47:34
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syMenu
	 * @return
	 */
	public SyMenu saveSyMenu(SyMenu syMenu){
		return null;
	}
}
