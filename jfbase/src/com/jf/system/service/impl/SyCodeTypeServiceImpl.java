package com.jf.system.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jf.framework.service.impl.BaseServiceImpl;
import com.jf.system.dao.SyCodeTypeDao;
import com.jf.system.model.SyCodeType;
import com.jf.system.service.SyCodeTypeService;

/**
 * @描述:<p>代码类型Service实现类</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午2:00:57
 */
@Service("syCodeTypeService")
public class SyCodeTypeServiceImpl extends BaseServiceImpl implements SyCodeTypeService{
	@Autowired
	@Resource(name = "syCodeTypeDao")
	private SyCodeTypeDao syCodeTypeDao;
	
	/**
	 * @描述:<p>保存代码类型 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-8 下午1:44:29
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param syCodeType
	 * @return
	 */
	public SyCodeType saveSyCodeType(SyCodeType syCodeType){
		return null;
	}
}
