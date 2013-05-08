package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>代码类型 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午7:52:13
 */
@Entity
@Table(name = "sy_code_type")
public class SyCodeType extends EntityBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7728113666718814139L;
	/**
	 * 代码编码
	 */
	@Column(name="code", nullable=false,length=50,columnDefinition="varchar(50)")
	private String code;
	
	/**
	 * 代码父编码
	 */
	@Column(name="parentCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String parentCode;
	
	/**
	 * 代码类型名称
	 */
	@Column(name="codeTypeName", nullable=false,length=100,columnDefinition="varchar(100)")
	private String codeTypeName;
	
	/**
	 * 是否系统内
	 */
	@Column(name="isSystem", nullable=false,length=10,columnDefinition="varchar(10)")
	private String isSystem;
	
	/**
	 * 使用范围：0集团，1子公司，2孙公司，3部门
	 */
	@Column(name="scope", nullable=false,length=10,columnDefinition="varchar(10)")
	private String scope;
	
	/**
	 * 描述
	 */
	@Column(name="codeTypeDesc", nullable=false,length=500,columnDefinition="varchar(500)")
	private String codeTypeDesc;

	
	public SyCodeType() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}



	public String getCodeTypeName() {
		return codeTypeName;
	}

	public void setCodeTypeName(String codeTypeName) {
		this.codeTypeName = codeTypeName;
	}

	public String getIsSystem() {
		return isSystem;
	}

	public void setIsSystem(String isSystem) {
		this.isSystem = isSystem;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getCodeTypeDesc() {
		return codeTypeDesc;
	}

	public void setCodeTypeDesc(String codeTypeDesc) {
		this.codeTypeDesc = codeTypeDesc;
	}

}
