package com.jf.framework.exception;

/**
 * @描述:<p>系统异常类 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-12-11 下午03:12:22
 */
public class SystemException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3060744948114294958L;
	
	/**
	 * 构造方法
	 */
	public SystemException() {
		super();
	}
	/**
	 * 构造方法
	 */
	public SystemException(String msg){
		super(msg);
	}
	
	/**
	 * 构造方法
	 */
	public SystemException(String msg, Throwable throwable){
		super(msg);
		throwable.printStackTrace();	
	}

}
