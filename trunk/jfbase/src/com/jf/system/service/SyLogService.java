package com.jf.system.service;

import com.jf.framework.service.BaseService;
import com.jf.system.model.SyLog;

/**
 * @描述:<p>日志Service接口 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午1:48:07
 */
public interface SyLogService extends BaseService{
	/**
	 * @描述:<p>保存日志</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:48:10
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syLog
	 * @return
	 */
	public SyLog saveSyLog(SyLog syLog);
}
