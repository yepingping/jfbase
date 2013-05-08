package com.jf.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.jf.framework.entity.base.EntityBase;

/**
 * @描述:<p>功能 菜单</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-5 下午8:50:56
 */
@Entity
@Table(name = "sy_menu")
public class SyMenu extends EntityBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8802855070227389890L;
	
	/**
	 * 菜单编码
	 */
	@Column(name="menuCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String menuCode;
	
	/**
	 * 菜单父编码
	 */
	@Column(name="menuParentCode", nullable=false,length=50,columnDefinition="varchar(50)")
	private String menuParentCode;
	
	/**
	 * 菜单名称
	 */
	@Column(name="menuName", nullable=false,length=100,columnDefinition="varchar(100)")
	private String menuName;
	
	/**
	 * 菜单路径
	 */
	@Column(name="menuUrl", nullable=false,length=500,columnDefinition="varchar(500)")
	private String menuUrl;
	
	/**
	 * 菜单图片
	 */
	@Column(name="menuIcon", nullable=false,length=50,columnDefinition="varchar(50)")
	private String menuIcon;
	
	/**
	 * 是否有子节点
	 */
	@Column(name="isLeaf", nullable=false)
	private boolean isLeaf;
	
	
	/**
	 * 排序
	 */
	@Column(name="orderNo", nullable=false,length=2,columnDefinition="varchar(2)")
	private Integer orderNo;
	
	/**
	 * 此节点是否展开
	 */
	@Column(name="expanded", nullable=false)
	private boolean expanded;
	
	/**
	 * 描述
	 */
	@Column(name="menuDesc", nullable=false,length=500,columnDefinition="varchar(500)")
	private String menuDesc;

	
	public SyMenu() {
		super();
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuParentCode() {
		return menuParentCode;
	}

	public void setMenuParentCode(String menuParentCode) {
		this.menuParentCode = menuParentCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

}
