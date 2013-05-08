package com.jf.common.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestContext {
	/**本地变量，用来保存当前对象的*/
    private final static ThreadLocal<RequestContext> local = new ThreadLocal<RequestContext>();
    private HttpSession session;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Cookie> cookies;
    private ServletContext context;
    /**
     * 初始化请求上下文
     * @param ctx
     * @param req
     * @param res
     */
    public static RequestContext begin(ServletContext ctx, HttpServletRequest req, HttpServletResponse res) {
        RequestContext rc = new RequestContext();
        rc.context = ctx;
        rc.request = req;
        rc.response = res;
        rc.response.setCharacterEncoding("UTF-8");
        rc.session = req.getSession(false);
        rc.cookies = new HashMap<String, Cookie> ();
        Cookie[] cookies = req.getCookies();
        if(cookies != null)
            for(Cookie ck : cookies) {
                rc.cookies.put(ck.getName(), ck);
            }
        local.set(rc);
        return rc;
    }
    /**
     * 获取当前请求的上下文
     * @return
     */
    public static RequestContext get(){
        return local.get();
    }

    public void end() {
        this.context = null;
        this.request = null;
        this.response = null;
        this.session = null;
        this.cookies = null;
        local.remove();
    }

    /**
     * 获取session
     * @return
     */
    public HttpSession session() { return session; }

    /**
     * 获取session
     * @param create 是否新创建一个
     * @return
     */
    public HttpSession session(boolean create) {
        return (session==null && create)?(session=request.getSession()):session;
    }

    /**
     * 获取session属性对应的值得
     * @param attr
     * @return
     */
    public Object sessionAttr(String attr) {
        HttpSession ssn = session();
        return (ssn!=null)?ssn.getAttribute(attr):null;
    }

    /**
     * 获取请求对象
     * @return
     */
    public HttpServletRequest request() { return request; }

    /**
     * 响应对象
     * @return
     */
    public HttpServletResponse response() { return response; }
}
