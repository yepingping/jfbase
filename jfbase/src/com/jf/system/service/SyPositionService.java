package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyPosition;

/**
 * @描述:<p>职位岗位Service接口</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:46:46
 */
public interface SyPositionService extends BaseService{
	/**
	 * @描述:<p> 保存职位岗位</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:46:49
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syPosition
	 * @return
	 */
	public SyPosition saveSyPosition(SyPosition syPosition);
}
