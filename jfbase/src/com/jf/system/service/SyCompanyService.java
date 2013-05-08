package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyCompany;

/**
 * @描述:<p>公司Service接口 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:45:32
 */
public interface SyCompanyService extends BaseService{
	/**
	 * @描述:<p>保存公司</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:45:30
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syCompany
	 * @return
	 */
	public SyCompany saveSyCompany(SyCompany syCompany);
}
