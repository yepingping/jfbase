package com.jf.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.jf.framework.dao.BaseDaoImpl;
import com.jf.system.dao.SyButtonDao;
import com.jf.system.model.SyButton;

/**
 * @描述:<p>功能按钮Dao实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 上午11:58:53
 */
@Repository("syButtonDao")
public class SyButtonDaoImpl  extends BaseDaoImpl<SyButton> implements SyButtonDao{

	/**
	 * 构造方法
	 */
	public SyButtonDaoImpl() {
		// TODO Auto-generated constructor stub
	}
}
