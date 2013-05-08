package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>日志 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午9:29:52
 */
@Entity
@Table(name = "sy_log")
public class SyLog extends EntityBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4880579025438694724L;
	
	/**
	 * 操作耗时
	 */
	@Column(name="doCost", nullable=false,length=100,columnDefinition="varchar(100)")
	private Long doCost;
	
	/**
	 * 操作的内容
	 */
	@Column(name="doContent", nullable=false,length=500,columnDefinition="varchar(500)")
	private String doContent;
	
	/**
	 * 操作时间
	 */
	@Column(name="doDate", nullable=false,length=30,columnDefinition="varchar(30)")
	private String doDate;
	
	/**
	 * 操作的ip
	 */
	@Column(name="doIp", nullable=false,length=100,columnDefinition="varchar(100)")
	private String doIp;
	
	/**
	 * 操作者
	 */
	@Column(name="doUser", nullable=false,length=32,columnDefinition="varchar(32)")
	private String doUser;
	
	/**
	 * 操作类型
	 */
	@Column(name="doType", nullable=false,length=10,columnDefinition="varchar(10)")
	private String doType;
	
	/**
	 * 操作描述
	 */
	@Column(name="doDesc", nullable=false,length=500,columnDefinition="varchar(500)")
	private String doDesc;

	
	public SyLog() {
		super();
	}

	public Long getDoCost() {
		return doCost;
	}

	public void setDoCost(Long doCost) {
		this.doCost = doCost;
	}

	public String getDoContent() {
		return doContent;
	}

	public void setDoContent(String doContent) {
		this.doContent = doContent;
	}

	public String getDoDate() {
		return doDate;
	}

	public void setDoDate(String doDate) {
		this.doDate = doDate;
	}

	public String getDoIp() {
		return doIp;
	}

	public void setDoIp(String doIp) {
		this.doIp = doIp;
	}

	public String getDoUser() {
		return doUser;
	}

	public void setDoUser(String doUser) {
		this.doUser = doUser;
	}

	public String getDoType() {
		return doType;
	}

	public void setDoType(String doType) {
		this.doType = doType;
	}

	public String getDoDesc() {
		return doDesc;
	}

	public void setDoDesc(String doDesc) {
		this.doDesc = doDesc;
	}
	

}
