package com.jf.framework.interceptor;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LogInterceptor {

	public Object invoke(ProceedingJoinPoint point) throws Throwable {
		Object result = null;
		// 执行方法名
		String name = point.getSignature().getName();
		Long start = System.currentTimeMillis();
		result = point.proceed();
		Long end = System.currentTimeMillis();
		// 日志需要的dongdong
		// 当前用户
		String user = "";
		String opertype = "";
		if (name.contains("save")) {
			opertype = "save操作";
		}
		if (name.contains("update")) {
			opertype = "update操作";
		}
		if (name.contains("del")) {
			opertype = "delte操作";
		}
		// 内容
		String content = user + ",用户执行" + name + "方法";
		// ip
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		// 所耗时间
		Long time = end - start;
		// 日志时间
		Date date = new Date();
		java.text.SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		// 备注
		String desc = name + "方法";
		return result;
	}
}
