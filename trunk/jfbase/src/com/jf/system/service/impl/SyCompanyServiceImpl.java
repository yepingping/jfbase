package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyCompanyDao;
import com.jf.system.model.SyCompany;
import com.jf.system.service.SyCompanyService;

/**
 * @描述:<p>公司Service实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午2:01:56
 */
@Service("syCompanyService")
public class SyCompanyServiceImpl  extends BaseServiceImpl implements SyCompanyService{
	@Autowired
	@Resource(name = "syCompanyDao")
	private SyCompanyDao syCompanyDao;
	/**
	 * 构造方法
	 */
	public SyCompanyServiceImpl() {
		// TODO Auto-generated constructor stub
	}
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
	public SyCompany saveSyCompany(SyCompany syCompany){
		return null;
	}
}
