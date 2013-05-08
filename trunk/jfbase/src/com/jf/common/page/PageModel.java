package com.jf.common.page;

import java.util.List;

/**
 * @描述:<p>分页工具 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-6-23 下午11:55:42
 */
public class PageModel<T> {
	
	/**
	 * 页面数据
	 */
	private List<T> result = null;
	/**
	 * 总记录数
	 */
	private long totalRows;
	
	/**
	 * 
	 */
	private String success = "true";
	
	/**
	 * 构造方法
	 */
	public PageModel() {
		super();
	}
	/**
	 * 构造方法
	 */
	public PageModel(List<T> result, int totalRows) {
		super();
		this.result = result;
		this.totalRows = totalRows;
	}
	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}
	public long getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}

	
	
	
}
