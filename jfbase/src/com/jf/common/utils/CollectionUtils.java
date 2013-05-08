/**
 * CollectionUtils.java	  V1.0   2011-12-14 下午05:25:34
 *
 * Copyright 2009 Kind YiXin Technology Co.,Ltd. All rights reserved.
 *
 * Modification history(By    Time    Reason):
 * 
 * Description:
 */

package com.jf.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.bytecode.Descriptor.Iterator;

/**
 * 功能描述：
 *
 * @author  叶平平(ypp)
 *
 * <p>修改历史：(修改人，修改时间，修改原因/内容)</p>
 */
public final class CollectionUtils {

	/**
	 * 构造函数：
	 *
	 */
	private CollectionUtils() {
	}

	public static boolean listIsNullOrEmpty(List list){
		boolean flag = false;
		if(list == null || list.size() <=0){
			flag = true;
		}
		return flag;
	}
	

	public static boolean mapIsNullOrEmpty(Map map){
		boolean flag = false;
		if(map == null || map.size() <=0){
			flag = true;
		}
		return flag;
	}
	@SuppressWarnings("unchecked")
	public static HashMap converArrayListToHashMap(ArrayList list){
		HashMap hashMap = new HashMap();
		if(list != null && list.isEmpty()){
			int i= 0;
			for(Iterator it = (Iterator) list.iterator(); it.hasNext();){
				hashMap.put(Integer.toString(i), it.next());
				i++;
			}
		}
		return hashMap;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList convertHashMapToArrayList(HashMap map){
		ArrayList list = null;
		if(map != null && !map.isEmpty()){
			list = new ArrayList(map.values());
		}else{
			list = new ArrayList();
		}
		return list;
	}
}
