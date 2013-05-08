package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>部门 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午8:18:20
 */

@Entity
@Table(name="sy_department")
public class SyDepartment  extends EntityBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1525158717086119467L;
	
	/**
	 * 部门编码
	 */
	@Column(name="departmentCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String departmentCode;
	
	/**
	 * 部门父编码
	 */
	@Column(name="departmentParentCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String departmentParentCode;
	
	/**
	 * 部门名称
	 */
	@Column(name="departmentName", nullable=false,length=100,columnDefinition="varchar(100)")
	private String departmentName;
	
	/**
	 * 部门级别
	 */
	@Column(name="level", nullable=false,length=2,columnDefinition="varchar(2)")
	private String level;
	
	/**
	 * 业务编号
	 */
	@Column(name="businessNo", nullable=false,length=10,columnDefinition="varchar(10)")
	private String businessNo;
	
	/**
	 * 排序
	 */
	@Column(name="orderNo", nullable=false,length=2,columnDefinition="varchar(2)")
	private Integer orderNo;
	
	/**
	 * 描述
	 */
	@Column(name="departmentDesc", nullable=false,length=500,columnDefinition="varchar(500)")
	private String departmentDesc;

	
	
	public SyDepartment() {
		super();
	}



	public String getDepartmentCode() {
		return departmentCode;
	}



	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}



	public String getDepartmentParentCode() {
		return departmentParentCode;
	}



	public void setDepartmentParentCode(String departmentParentCode) {
		this.departmentParentCode = departmentParentCode;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public String getLevel() {
		return level;
	}



	public void setLevel(String level) {
		this.level = level;
	}



	public String getBusinessNo() {
		return businessNo;
	}



	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}



	public Integer getOrderNo() {
		return orderNo;
	}



	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}



	public String getDepartmentDesc() {
		return departmentDesc;
	}



	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	

}
