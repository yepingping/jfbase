package com.jf.common.session;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jf.common.utils.StringUtil;
import com.jf.system.model.SyUser;
public class SessionHelper {
	
    /**
     * 存储登录的所有登录员工的登录信息列表
     */
	private static final Map<String,Object> sessionMembers = new HashMap<String,Object>();
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private final Lock r = lock.readLock();
	private final Lock w = lock.writeLock();
	
	 /**
     * <p>用户登陆时， 将用户信息放到Session变量中</p>
     * @return 
     */
	public void setLoginInfo(){
		this.setSessionObject(SessionConstants.USER, "");
	}
	 /**
     * <p>调用每个Action时，需要把Session中的用户信息内容，放到进程变量中以供数据权限，功能权限作控制</p>
     * @return 
     */
	public void sessionInfo(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		
		if(null != ra){
			HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
			if(null != request.getSession()){
				 // 清除原线程中usersession的信息
				SessionUser.clear();
				SyUser user = (SyUser)request.getSession().getAttribute(SessionConstants.USER.getValue());
				if(!StringUtil.isNullOrEmpty(user)){
					SessionUser.set(SessionConstants.USER.getValue(), user);
					SessionUser.set(SessionConstants.USER_ID.getValue(), user.getIds());
					SessionUser.set(SessionConstants.DEPT_ID.getValue(), "");
					SessionUser.set(SessionConstants.COMPANY_ID.getValue(), "");
				}
			}
		}
	}
	 /**
     * <p>清空Session中的用户信息数据</p>
     * @return 
     */
	public void resetSessionInfo(){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		if(null != ra){
			HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
			request.getSession().removeAttribute(SessionConstants.COMPANY.getValue());
			request.getSession().removeAttribute(SessionConstants.USER.getValue());
		}
		
	}
	 /**
     * <p>将登陆用户信息放到列表中</p>
     * @return 
     */
	@SuppressWarnings("static-access")
	public void addSessionInfo(SessionModel sessionModel){
		w.lock();
		try {
			this.sessionMembers.put(sessionModel.getUserId(), sessionModel);
		} catch (Exception e) {
			w.unlock();
		}
	}
    /**
     * <p>将对象放到Session中</p>
     * @param sessionConstants
     * @param object
     * @return 
     */
	public void setSessionObject(SessionConstants sessionConstants,Object object){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		if(null != ra){
			HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
			request.getSession().setAttribute(sessionConstants.getValue(), object);
		}
		
	}
	
	   /**
     * <p>获得Session中的对象(非系统对象)</p>
     * @param sessionConstants
     * @param object
     * @return 
     */
	public Object getSessionObject(SessionConstants sessionConstants){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		if(null != ra){
			HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
			return request.getSession().getAttribute(sessionConstants.getValue());
		}
		return null;
	}

}
