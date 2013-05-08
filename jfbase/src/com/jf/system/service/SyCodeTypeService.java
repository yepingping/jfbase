package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyCodeType;

/**
 * @描述:<p>代码类型Service接口</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:44:17
 */
public interface SyCodeTypeService extends BaseService{

	/**
	 * @描述:<p>保存代码类型 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:44:29
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syCodeType
	 * @return
	 */
	public SyCodeType saveSyCodeType(SyCodeType syCodeType);
}
