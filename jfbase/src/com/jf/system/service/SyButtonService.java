package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyButton;

/**
 * @描述:<p>功能按钮Service接口</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:40:55
 */
public interface SyButtonService extends BaseService {
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
	public SyButton saveSyButton(SyButton syButton);
}
