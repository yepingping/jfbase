package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>公司 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午8:05:26
 */
@Entity
@Table(name = "sy_company")
public class SyCompany extends EntityBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -164034273889694282L;

	/**
	 * 公司编码
	 */
	@Column(name="companyCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String companyCode;
	
	/**
	 * 公司父编码
	 */
	@Column(name="companyParentCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String companyParentCode;
	
	/**
	 * 公司名称
	 */
	@Column(name="companyName", nullable=false,length=100,columnDefinition="varchar(100)")
	private String companyName;
	
	/**
	 * 业务编号
	 */
	@Column(name="businessNo", nullable=false,length=10,columnDefinition="varchar(10)")
	private String businessNo;
	
	/**
	 * 部门级别
	 */
	@Column(name="level", nullable=false,length=2,columnDefinition="varchar(2)")
	private String level;
	/**
	 * 排序
	 */
	@Column(name="orderNo", nullable=false,length=2,columnDefinition="varchar(2)")
	private Integer orderNo;
	/**
	 * 描述
	 */
	@Column(name="companyDesc", nullable=false,length=500,columnDefinition="varchar(500)")
	private String companyDesc;

	
	public SyCompany() {
		super();
	}


	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getCompanyParentCode() {
		return companyParentCode;
	}


	public void setCompanyParentCode(String companyParentCode) {
		this.companyParentCode = companyParentCode;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getBusinessNo() {
		return businessNo;
	}


	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public Integer getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}


	public String getCompanyDesc() {
		return companyDesc;
	}


	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}



}
