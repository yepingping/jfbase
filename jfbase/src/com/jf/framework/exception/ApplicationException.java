package com.jf.framework.exception;

import org.apache.log4j.Logger;

/**
 * @描述:<p>定义应用信息的检查例外 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-12-11 下午03:16:42
 */
public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9117498813422107548L;
	
	Logger log = Logger.getLogger("");
	
	/**
	 * 构造方法
	 */
	public ApplicationException() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 构造方法
	 */
	public ApplicationException(String msg){
		super(msg);
	}
	
	/**
	 * 构造方法
	 */
	public ApplicationException(Throwable throwable){
		super(throwable);
	}
	
	/**
	 * 构造方法
	 */
	public ApplicationException(String msg, Throwable throwable){
		super(msg, throwable);
	}

}
