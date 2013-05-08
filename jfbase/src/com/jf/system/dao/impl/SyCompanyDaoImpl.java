package com.jf.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.jf.framework.dao.BaseDaoImpl;
import com.jf.system.dao.SyCompanyDao;
import com.jf.system.model.SyCompany;

/**
 * @描述:<p>公司Dao实现类</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午12:12:11
 */
@Repository("syCompanyDao")
public class SyCompanyDaoImpl extends BaseDaoImpl<SyCompany> implements SyCompanyDao{
	/**
	 * 构造方法
	 */
	public SyCompanyDaoImpl() {
		// TODO Auto-generated constructor stub
	}
}
