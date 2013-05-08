package com.jf.framework.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;



import com.jf.common.config.FinalConstants;

/**
 * @描述:<p>基础实体类</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-6-19 下午01:11:39
 */
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class EntityBase  implements Serializable{
	/**
	 * 实体ID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ids",length=20,unique=true,columnDefinition="bigint(20)")
	protected String ids;
	
	/**
	 * 创建人Id
	 */
	@Column(name="crUserId",nullable=true,length=32,columnDefinition="varchar(32)")
	protected String crUserId;
	
	/**
	 * 创建部门Id
	 */
	@Column(name="crDeptId",nullable=true,length=32,columnDefinition="varchar(32)")
	protected String crDeptId;
	
	/**
	 * 创建公司Id
	 */
	@Column(name="crCompanyId",nullable=true,length=32,columnDefinition="varchar(32)")
	protected String crCompanyId;
	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true, name="crDate")
	protected Date crDate;
	/**
	 * 最后修改人Id
	 */
	@Column(name="moUserId",nullable=true,length=32,columnDefinition="varchar(32)")
	protected String moUserId;
	
	/**
	 * 最后修改部门Id
	 */
	@Column(name="moDeptId",nullable=true,length=32,columnDefinition="varchar(32)")
	protected String moDeptId;
	
	/**
	 * 最后修改公司Id
	 */
	@Column(name="moCompanyId",nullable=true,length=32,columnDefinition="varchar(32)")
	protected String moCompanyId;
	/**
	 * 最后修改时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=true, name="moDate")
	protected Date moDate;
	/**
	 * 是否有效
	 */
	@Column(name="isValid",nullable=true,length=7,columnDefinition="varchar(7)")
	protected String isValid = FinalConstants.ISVALID_YES;
	/**
	 * 版本控制
	 */
	@Version
	@Column(name="version", nullable=true,columnDefinition="bigint(20)")
	protected Long version;
	public String getIds() {
		return ids;
	}
	public void setId(String ids) {
		this.ids = ids;
	}
	public String getCrUserId() {
		return crUserId;
	}
	public void setCrUserId(String crUserId) {
		this.crUserId = crUserId;
	}
	public String getCrDeptId() {
		return crDeptId;
	}
	public void setCrDeptId(String crDeptId) {
		this.crDeptId = crDeptId;
	}
	public String getCrCompanyId() {
		return crCompanyId;
	}
	public void setCrCompanyId(String crCompanyId) {
		this.crCompanyId = crCompanyId;
	}
	public Date getCrDate() {
		return crDate;
	}
	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}
	public String getMoUserId() {
		return moUserId;
	}
	public void setMoUserId(String moUserId) {
		this.moUserId = moUserId;
	}
	public String getMoDeptId() {
		return moDeptId;
	}
	public void setMoDeptId(String moDeptId) {
		this.moDeptId = moDeptId;
	}
	public String getMoCompanyId() {
		return moCompanyId;
	}
	public void setMoCompanyId(String moCompanyId) {
		this.moCompanyId = moCompanyId;
	}
	public Date getMoDate() {
		return moDate;
	}
	public void setMoDate(Date moDate) {
		this.moDate = moDate;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
	
	
	
}
