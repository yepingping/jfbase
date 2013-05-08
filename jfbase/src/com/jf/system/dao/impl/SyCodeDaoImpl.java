package com.jf.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.jf.framework.dao.BaseDaoImpl;
import com.jf.system.dao.SyCodeDao;
import com.jf.system.model.SyCode;

/**
 * @描述:<p>代码Dao实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午12:06:02
 */
@Repository("syCodeDao")
public class SyCodeDaoImpl  extends BaseDaoImpl<SyCode> implements SyCodeDao{
	/**
	 * 构造方法
	 */
	public SyCodeDaoImpl() {
		// TODO Auto-generated constructor stub
	}
}
