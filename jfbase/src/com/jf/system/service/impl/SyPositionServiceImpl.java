package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyPositionDao;
import com.jf.system.model.SyPosition;
import com.jf.system.service.SyPositionService;

/**
 * @描述:<p>职位岗位Service实现类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午2:08:03
 */
@Service("syPositionService")
public class SyPositionServiceImpl extends BaseServiceImpl implements SyPositionService{
	@Autowired
	@Resource(name = "syPositionDao")
	private SyPositionDao syPositionDao;
	/**
	 * 构造方法
	 */
	public SyPositionServiceImpl() {
		// TODO Auto-generated constructor stub
	}
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
	public SyPosition saveSyPosition(SyPosition syPosition){
		return null;
	}
	
}
