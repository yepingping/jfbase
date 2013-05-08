package com.jf.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;


/**
 * @描述:<p>反射的Util函数集合. 提供访问私有变量,获取泛型类型Class,
 *          提取集合中元素的属性等Util函数.
 *       </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2011-11-7 下午10:45:10
 */
public class ReflectionUtil {

	private static Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

	private ReflectionUtil() {
	}

	/**
	 * 直接读取对象属性值,无视private/protected修饰符,不经过getter函数.
	 */
	public static Object getFieldValue(final Object object, final String fieldName) {
		Field field = getDeclaredField(object, fieldName);

		if (field == null)
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");

		makeAccessible(field);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常{}", e.getMessage());
		}
		return result;
	}

	/**
	 * 直接设置对象属性值,无视private/protected修饰符,不经过setter函数.
	 */
	public static void setFieldValue(final Object object, final String fieldName, final Object value) {
		Field field = getDeclaredField(object, fieldName);

		if (field == null)
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");

		makeAccessible(field);

		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}
	}

	/**
	 * 循环向上转型,获取对象的DeclaredField.
	 */
	protected static Field getDeclaredField(final Object object, final String fieldName) {
		Assert.notNull(object, "object不能为空");
		return getDeclaredField(object.getClass(), fieldName);
	}

	/**
	 * 循环向上转型,获取类的DeclaredField.
	 */
	@SuppressWarnings("unchecked")
	protected static Field getDeclaredField(final Class clazz, final String fieldName) {
		Assert.notNull(clazz, "clazz不能为空");
		Assert.hasText(fieldName, "fieldName");
		for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
				// Field不在当前类定义,继续向上转型
			}
		}
		return null;
	}

	/**
	 * 强制转换fileld可访问.
	 */
	protected static void makeAccessible(final Field field) {
		if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
			field.setAccessible(true);
		}
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的泛型参数的类型. 如public UserDao extends HibernateDao<User>
	 * 
	 * @param clazz
	 *            The class to introspect
	 * @return the first generic declaration, or Object.class if cannot be
	 *         determined
	 */
	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(final Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的泛型参数的类型. 如public UserDao extends
	 * HibernateDao<User,Long>
	 * 
	 * @param clazz
	 *            clazz The class to introspect
	 * @param index
	 *            the Index of the generic ddeclaration,start from 0.
	 * @return the index generic declaration, or Object.class if cannot be
	 *         determined
	 */

	@SuppressWarnings("unchecked")
	public static Class getSuperClassGenricType(final Class clazz, final int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}
		return (Class) params[index];
	}

	/**
	 * 提取集合中的对象的属性,组合成List.
	 * 
	 * @param collection
	 *            来源集合.
	 * @param propertityName
	 *            要提取的属性名.
	 */
	@SuppressWarnings("unchecked")
	public static List fetchElementPropertyToList(final Collection collection, final String propertyName) throws Exception {

		List list = new ArrayList();

		for (Object obj : collection) {
			list.add(PropertyUtils.getProperty(obj, propertyName));
		}

		return list;
	}

	/**
	 * 提取集合中的对象的属性,组合成由分割符分隔的字符串.
	 * 
	 * @param collection
	 *            来源集合.
	 * @param propertityName
	 *            要提取的属性名.
	 * @param separator
	 *            分隔符.
	 */
	@SuppressWarnings("unchecked")
	public static String fetchElementPropertyToString(final Collection collection, final String propertyName, final String separator) throws Exception {
		List list = fetchElementPropertyToList(collection, propertyName);
		return StringUtils.join(list.toArray(), separator);
	}
	
	 /**
	 * @描述:<p>对象复制，将源对象中的和目标对象相同的属性进行复制，只复制JAVA的所有基本类型，不包括引用类型  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-13 下午08:40:55
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param srcObj 		源对象
	 * @param destObj		目标对象
	 * @throws Exception	异常
	 */
	@SuppressWarnings("unchecked")
	public static void copyProperties(Object srcObj, Object destObj) throws Exception {

	        Class src = srcObj.getClass();
	        
	        Class dest = destObj.getClass();
	        
	        Method[] ms = dest.getMethods();
	        if (src != dest && src == dest.getSuperclass()) {
	            ms = src.getMethods();
	        }
	        
	        for (int i = 0; i < ms.length; i++) {
	            
	            String name = ms[i].getName();
	            if (name.startsWith("set")) {
	                
	                Class[] cc = ms[i].getParameterTypes();
	                if (cc.length == 1) {
	                    
	                    // parameter type
	                    String type = cc[0].getName();
	                    
	                    // 为了通过checkStyle的校验，提出来
	                    boolean isBasicDataType = "int".equals(type)
	                            || "java.lang.Integer".equals(type);
	                    isBasicDataType = isBasicDataType || "long".equals(type)
	                            || "java.lang.Long".equals(type);
	                    isBasicDataType = isBasicDataType || "boolean".equals(type)
	                            || "java.lang.Boolean".equals(type)
	                            || "java.math.BigDecimal".equals(type);
	                    
	                    if (isBasicDataType || "java.lang.String".equals(type)
	                            || "java.util.Date".equals(type)) {
	                        
	                        // get property name:
	                        String getMethod = "g" + name.substring(1);
	                        // call get method:
	                        Method getM = src.getMethod(getMethod, new Class[0]);
	                        Object ret = getM.invoke(srcObj, new Object[] {});
	                        
	                        if (ret != null) {
	                            ms[i].invoke(destObj, new Object[] {ret });
	                        }
	                    }
	                    
	                }
	            }
	        }
	    }
}
