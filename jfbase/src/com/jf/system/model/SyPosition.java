package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>职位岗位</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午8:46:17
 */
@Entity
@Table(name = "sy_position")
public class SyPosition extends EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 职位编码
	 */
	@Column(name="positionCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String positionCode;
	/**
	 * 职位名称
	 */
	@Column(name="positionName", nullable=false,length=100,columnDefinition="varchar(100)")
	private String positionName;
	
	/**
	 * 描述
	 */
	@Column(name="positionDesc", nullable=false,length=100,columnDefinition="varchar(100)")
	private String positionDesc;

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionDesc() {
		return positionDesc;
	}

	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}
	
	

}
