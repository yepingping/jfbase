package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>角色 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午7:47:50
 */
@Entity
@Table(name = "sy_role")
public class SyRole extends EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7986712119305956349L;
	
	/**
	 * 角色名称
	 */
	@Column(name="roleName", nullable=false,length=100,columnDefinition="varchar(100)")
	private String roleName;
	
	/**
	 * 角色描述
	 */
	@Column(name="roleDesc", nullable=false,length=500,columnDefinition="varchar(500)")
	private String roleDesc;

	
	public SyRole() {
		super();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
}
