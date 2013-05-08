package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyLogDao;
import com.jf.system.model.SyLog;
import com.jf.system.service.SyLogService;

/**
 * @描述:<p>日志Service实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午2:04:20
 */
@Service("syLogService")
public class SyLogServiceImpl extends BaseServiceImpl implements SyLogService{
	@Autowired
	@Resource(name = "syLogDao")
	private SyLogDao syLogDao;
	/**
	 * 构造方法
	 */
	public SyLogServiceImpl() {
		// TODO Auto-generated constructor stub
	}
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
	public SyLog saveSyLog(SyLog syLog){
		return null;
	}
}
