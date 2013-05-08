/**
 * @描述:<p>Sting工具 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-7-23 下午03:44:09
 */

package com.jf.common.utils;

import java.util.Arrays;

public class StringUtil {
	
	public StringUtil() {
	}
	/**
	 * 功能描述：补零
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：2011-7-23 下午03:44:09</p>
	 *
	 * @param value
	 * @param maxLen
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static String addZero(String value, int maxLen){
		int length = maxLen - value.length();
		String ret = value;
		if(length > 0){
			char zero[] = new char[length];
			Arrays.fill(zero, '0');
			String sZero = new String(zero);
			ret = (new StringBuffer()).append(sZero).append(ret).toString();
		}
		return ret;
	}
	/**
	 * 功能描述：补零
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：2011-7-23 下午03:44:09</p>
	 *
	 * @param value
	 * @param maxLen
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static String addZero(int value, int maxLen){
		String sValue = Integer.toString(value);
		return addZero(sValue, maxLen);
	}
	
	/**
	 * 功能描述：判断是否不为NULL
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：2011-7-23 下午03:44:09</p>
	 *
	 * @param obj
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static boolean isNotNull(Object obj){
		boolean flag = false;
		if(null != obj){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 功能描述：判断是否为NULL或""
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：2011-7-23 下午03:44:09</p>
	 *
	 * @param obj
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static boolean isNullOrEmpty(Object obj){
		boolean flag = false;
		if(obj == null || "".equals(obj.toString().trim())){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 功能描述：判断是否为NULL
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：2011-7-23 下午03:44:09</p>
	 *
	 * @param obj
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static boolean isNull(Object obj){
		return obj == null;
	}
	
	/**
	 * 功能描述：判断是否为""
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：2011-7-23 下午03:44:09</p>
	 *
	 * @param str
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static boolean isEmpty(String str){
		if(isNull(str)){
			return true;
		}else{
			return str.trim().equals("");
		}
	}
	
	/**
	 * 功能描述：NULL转换为""
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：Jul 23, 2011 4:04:40 PM</p>
	 *
	 * @param str
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static String null2Str(String str){
		if(isEmpty(str)){
			return "";
		}else{
			return str;
		}
	}
	
	/**
	 * 功能描述：NULL转换为" "空格
	 *
	 * @author  叶平平(yepp)
	 * <p>创建日期 ：Jul 23, 2011 4:06:39 PM</p>
	 *
	 * @param str
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static String null2Space(String str){
		if(isNull(str)){
			return " ";
		}else{
			return str;
		}
	}
}
