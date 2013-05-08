package com.jf.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.jf.framework.dao.BaseDaoImpl;
import com.jf.system.dao.SyDepartmentDao;
import com.jf.system.model.SyDepartment;

/**
 * @描述:<p>部门Dao实现类</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午12:14:57
 */
@Repository("syDepartmentDao")
public class SyDepartmentDaoImpl extends BaseDaoImpl<SyDepartment> implements SyDepartmentDao{
	/**
	 * 构造方法
	 */
	public SyDepartmentDaoImpl() {
		// TODO Auto-generated constructor stub
	}
}
