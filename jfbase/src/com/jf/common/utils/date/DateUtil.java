package com.jf.common.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @描述:<p>时间工具类</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-7 下午10:48:06
 */
public class DateUtil {
	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_DATE = "yyyy-MM-dd";
	
	public static Date string2Date(String strDate,String pattern){
		if(strDate == null || strDate.equals("")){
			throw new RuntimeException("str date null");
		}
		if(pattern == null || pattern.equals("")){
			pattern = DateUtil.PATTERN_DATE;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e){
			throw new RuntimeException(e);
		}
		return date;
	}
}
