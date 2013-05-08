package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyCodeDao;
import com.jf.system.model.SyCode;
import com.jf.system.service.SyCodeService;

/**
 * @描述:<p> </p>
 * 
 * @作者: 叶平平(yepp)
 * 
 * @时间: 2013-5-8 下午1:41:37
 */
@Service("syCodeService")
public class SyCodeServiceImpl extends BaseServiceImpl implements SyCodeService {
	@Autowired
	@Resource(name = "syCodeDao")
	private SyCodeDao syCodeDao;

	public SyCodeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @描述:<p> </p>
	 * 
	 * @作者: 叶平平(yepp)
	 * 
	 * @时间: 2013-5-8 下午1:42:06
	 * 
	 * @修改历史: <p>
	 *        修改时间、修改人、修改原因/说明
	 *        </p>
	 * 
	 * @param syCode
	 * @return
	 */
	public SyCode saveSyCode(SyCode syCode) {
		return null;
	}
}
