package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>代码</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午7:52:43
 */
@Entity
@Table(name = "sy_code")
public class SyCode extends EntityBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -840670011717123074L;
	
	/**
	 * 代码
	 */
	@Column(name="code", nullable=false,length=6,columnDefinition="varchar(6)")
	private String code;
	
	/**
	 * 代码值
	 */
	@Column(name="codeValue", nullable=false,length=100,columnDefinition="varchar(100)")
	private String codeValue;
	
	/**
	 * 简称
	 */
	@Column(name="shortName", nullable=false,length=100,columnDefinition="varchar(100)")
	private String shortName;
	
	/**
	 * 关键字
	 */
	@Column(name="keyWord", nullable=false,length=100,columnDefinition="varchar(100)")
	private String keyWord;
	
	/**
	 * 顺序
	 */
	@Column(name="orderNo", nullable=false,length=2,columnDefinition="varchar(2)")
	private Integer orderNo;

	
	public SyCode() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

}
