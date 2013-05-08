package com.jf.framework.web;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.jf.framework.web.editor.DateEditor;
import com.jf.framework.web.editor.DoubleEditor;
import com.jf.framework.web.editor.IntegerEditor;
import com.jf.framework.web.editor.LongEditor;

/**
 * @描述:<p>基础控制类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-7 下午10:30:20
 */
public abstract class BaseController {

	
	protected ResourceBundleMessageSource res;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception{
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	protected ModelAndView ajaxDone(int statusCode,String message){
		ModelAndView modelAndView = new ModelAndView("ajaxDone");
		modelAndView.addObject("statusCode", statusCode);
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	/**
	 * @描述:<p>成功返回提示信息  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:39:32
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param message
	 * @return
	 */
	protected ModelAndView ajaxDoneSuccess(String message){
		return ajaxDone(200,message);
	}
	
	/**
	 * @描述:<p>失败返回提示信息 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:39:48
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param message
	 * @return
	 */
	protected ModelAndView ajaxDoneError(String message){
		return ajaxDone(200,message);
	}
	
	/**
	 * @描述:<p> 获取国际化信息 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:42:31
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param code
	 * @param args
	 * @return
	 */
	protected String getMessage(String code,Object[] args){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);
		return res.getMessage(code, args, locale);
	}
	/**
	 * @描述:<p> 获取国际化信息 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:44:22
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param code
	 * @return
	 */
	protected String getMessage(String code) {
		return this.getMessage(code, new Object[] {});
	}

	/**
	 * @描述:<p> 获取国际化信息 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:44:29
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param code
	 * @param arg0
	 * @return
	 */
	protected String getMessage(String code, Object arg0) {
		return getMessage(code, new Object[] { arg0 });
	}

	/**
	 * @描述:<p>获取国际化信息</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:44:36
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param code
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	protected String getMessage(String code, Object arg0, Object arg1) {
		return getMessage(code, new Object[] { arg0, arg1 });
	}

	/**
	 * @描述:<p>获取国际化信息</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:44:42
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param code
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @return
	 */
	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2) {
		return getMessage(code, new Object[] { arg0, arg1, arg2 });
	}

	/**
	 * @描述:<p>获取国际化信息</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2013-5-7 下午10:44:47
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param code
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return
	 */
	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2, Object arg3) {
		return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
	}
	
}
