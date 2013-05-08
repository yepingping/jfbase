package com.jf.common.session;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class SessionUser {

	/**
	 * 保存变量的ThreadLocal，保持在同一线程中同步数据
	 */
	private static final ThreadLocal SESSION_MAP = new ThreadLocal() {

		public Map initialValue() {

			return new HashMap();
		}
	};
	/**
	 * 构造函数：工具类的protected构造方法
	 *
	 */
	protected SessionUser() {

	}

	/**
	 * 功能描述：
	 *
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-1-6 下午12:38:49</p>
	 *
	 * @return
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static Map getMapVar() {

		Map map = (Map) SESSION_MAP.get();

		return map;
	}

	/**
	 * 功能描述：当前用户请求资源名称
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-1-6 下午12:38:55</p>
	 *
	 * @param attribute	属性名称
	 * @return			属性值
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static Object get(String attribute) {

		Map map = (Map) SESSION_MAP.get();
		return map.get(attribute);
	}

	/**
	 * 功能描述：获得线程中保存的属性，使用指定类型进行转型
	 *
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-1-6 下午12:40:20</p>
	 *
	 * @param <T>		自动转型
	 * @param attribute	属性名称
	 * @param clazz		类型
	 * @return			属性值
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static <T> T get(String attribute, Class<T> clazz) {

		return (T) get(attribute);
	}

	/**
	 * 功能描述：设置制定属性名的值
	 *
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-1-6 下午12:40:55</p>
	 *
	 * @param attribute	属性名称
	 * @param value		属性值
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static void set(String attribute, Object value) {

		Map map = (Map) SESSION_MAP.get();

		if (map == null) {
			map = new HashMap();
			SESSION_MAP.set(map);
		}

		map.put(attribute, value);
	}

	/**
	 * 功能描述：清楚map中的所有变量信息
	 *
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-1-6 下午12:41:17</p>
	 *
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static void clear() {
		Map map = (Map) SESSION_MAP.get();
		if (null != map) {
			map.clear();
		}
	}

	/**
	 * 功能描述：从usersession中删除指定的key
	 *
	 * @author  叶平平(ypp)
	 * <p>创建日期 ：2012-1-6 下午12:41:32</p>
	 *
	 * @param key
	 *
	 * <p>修改历史 ：(修改人，修改时间，修改原因/内容)</p>
	 */
	public static void remove(Object key) {
		Map map = (Map) SESSION_MAP.get();
		if (null != map) {
			map.remove(key);
		}
	}

}
