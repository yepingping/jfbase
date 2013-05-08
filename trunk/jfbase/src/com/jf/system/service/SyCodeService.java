package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyCode;

/**
 * @描述:<p> 代码Service接口</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:43:23
 */
public interface SyCodeService extends BaseService{
	/**
	 * @描述:<p> 保存代码</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:44:00
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syCode
	 * @return
	 */
	public SyCode saveSyCode(SyCode syCode);
}
