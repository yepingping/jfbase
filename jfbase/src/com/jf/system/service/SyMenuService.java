package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyMenu;

/**
 * @描述:<p>功能 菜单Service接口</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:47:36
 */
public interface SyMenuService extends BaseService{
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
	public SyMenu saveSyMenu(SyMenu syMenu);
}
