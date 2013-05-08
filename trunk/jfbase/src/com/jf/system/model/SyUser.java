package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;


/**
 * @描述:<p>用户 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-4-25 下午9:54:42
 */
@Entity
@Table(name = "sy_user")
public class SyUser extends EntityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5219124561816458039L;

	/**
	 * 用户名称
	 * store是否存储; boost:优先级
	 */
	@Column(name="userName", nullable=true,length=50,columnDefinition="varchar(50)")
	private String userName;
	
	/**
	 * 用户密码
	 * index:是否索引; store是否存储; boost:优先级
	 */
	@Column(name="passWord", nullable=true,length=200,columnDefinition="varchar(200)")
	private String passWord;

	
	public SyUser() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
