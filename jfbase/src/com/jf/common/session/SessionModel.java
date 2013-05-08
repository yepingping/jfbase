package com.jf.common.session;

import java.io.Serializable;

/**
 * 功能描述：用户session对象
 *
 * @author  叶平平(ypp)
 *
 * <p>修改历史：(修改人，修改时间，修改原因/内容)</p>
 */
@SuppressWarnings("serial")
public class SessionModel implements Serializable{
	/**
	 * 登录用户userId
	 */
	private String userId;
	
	/**
	 * 登录用户sessionId
	 */
	private String sessionId;
	
	/**
	 *  登录用户的登录IP
	 */
	private String loginIP;
	
	/**
	 * 登录用户的登录MAC地址
	 */
	private String loginMAC;
	
	/**
	 * 登录用户的机器名
	 */
	private String loginComputerName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public String getLoginMAC() {
		return loginMAC;
	}

	public void setLoginMAC(String loginMAC) {
		this.loginMAC = loginMAC;
	}

	public String getLoginComputerName() {
		return loginComputerName;
	}

	public void setLoginComputerName(String loginComputerName) {
		this.loginComputerName = loginComputerName;
	}
	
	
	
}
