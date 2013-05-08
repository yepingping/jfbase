package com.jf.framework.interceptor;

import java.util.Date;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import com.jf.common.datetime.DateConvertEditor;

/**
 * @描述:<p> </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午5:55:48
 */
public class MyWebBinding implements WebBindingInitializer{

	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

}
