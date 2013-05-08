package com.jf.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.jf.framework.exception.SystemException;
/**
 * @描述:<p>动态读取配置文件来加载属性 </p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2012-1-14 下午08:54:07
 */
public class PropertiesUtil {
	private static Logger log = Logger.getLogger(PropertiesUtil.class);
	
	private static Hashtable<String,Properties> hashtable = new Hashtable<String,Properties>();
	
	/**
	 * @描述:<p>从文件系统加载属性文件</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:09:41
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	路径
	 * @return
	 */
	private static Properties loadPropertyFileByFileSystem(final String path){
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(path));
			return properties;
		} catch (FileNotFoundException e) {
			log.error("FileInputStream(\"" + path + "\")! FileNotFoundException: " + e);
			new SystemException("FileInputStream(\"" + path + "\")! FileNotFoundException");
			return null;
		}catch (Exception e) {
			log.error("Properties.load(InputStream)! IOException:" + e);
			new SystemException("Properties.load(InputStream)! IOException:");
			return null;
		}
	}
	
	/**
	 * @描述:<p>加载属性文件</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:12:35
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件(包括类路径)
	 * @return
	 */
	private static Properties loadPropertyFile(String path){
		InputStream is = PropertiesUtil.class.getResourceAsStream(path);
		if(is == null){
			return loadPropertyFileByFileSystem(path);
		}
		Properties properties = new Properties();
		try {
			properties.load(is);
			return properties;
		} catch (Exception e) {
			log.error("加载属性文件出错:" + path, e);
			new SystemException("加载属性文件出错:" + path);
			return null;
		}
	}
	/**
	 * @描述:<p>获得属性文件的属性 </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:15:48
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件(包括类路径)
	 * @return		属性文件对象 Properties
	 */
	public final static Properties getProperties(String path){
		if(path == null){
			log.error("属性文件路径为空");
			return null;
		}
		Properties properties = hashtable.get(path);
		if(properties ==null){
			properties = loadPropertyFile(path);
			if(properties != null){
				properties.put(path, properties);
			}
		}
		return properties;
	}
	/**
	 * @描述:<p>获得属性文件的属性</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:18:07
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件路径(包括类路径及文件系统路径)
	 * @return		属性文件对象 Properties
	 */
	public final static Properties getPropertiesByFs(String path){
		if(path == null){
			log.error("属性文件路径为空");
			return null;
		}
		Properties properties = hashtable.get(path);
		if(properties ==null){
			properties = loadPropertyFileByFileSystem(path);
			if(properties != null){
				properties.put(path, properties);
			}
		}
		return properties;
	}
	
	/**
	 * @描述:<p>对存在的属性文件中添加键值对并保存</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:21:58
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path		属性文件的路径(包括类路径及文件系统路径)
	 * @param keyValue	键值对Hashtable
	 * @return
	 */
	public final static boolean setValueAndStore(String path,Hashtable<String,String> keyValue){
		return setValueAndStore(path,keyValue,null);
	}
	
	/**
	 * @描述:<p>对存在的属性文件中添加键值对并保存</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:36:14
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path		属性文件的路径(包括类路径及文件系统路径)
	 * @param keyValue	键值对Hashtable
	 * @param msg		保存时添加的附加信息（注释）
	 * @return
	 */
	public final static boolean setValueAndStore(String path, Hashtable<String,String> keyValue,String msg){
		Properties properties = getProperties(path);
		if(path == null || keyValue == null){
			return false;
		}
		properties.putAll(keyValue);
		OutputStream os = null;
		try {
			os = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			log.debug("path = " +path);
			String filePath = PropertiesUtil.class.getResource(path).getPath();
			log.debug("filePath = " + filePath);
			new SystemException("path = " + path + "  filePath = " + filePath);
			try {
				os = new FileOutputStream(filePath);
			} catch (FileNotFoundException e2) {
				log.error("FileNotFoundException! filePath = " + filePath);
				new SystemException("FileNotFoundException! filePath=" + filePath);
				return false;
			}
		}
		if(os == null){
			return false;
		}
		try {
			properties.store(os, msg != null ? msg : "set value and store.");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * @描述:<p>获得属性</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午10:08:32
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件(包括类路径)
	 * @param key	属性键
	 * @return		属性值
	 */
	public final static String getValue(String path, String key){
		Properties properties = getProperties(path);
		return properties == null ? null : properties.getProperty(key);
	}
	/**
	 * @描述:<p>创建属性文件</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:40:55
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path		要存储属性文件的路径
	 * @param keyValue	属性文件中的键值对Hashtable
	 * @return
	 */
	public final static boolean createPropertiesFile(String path, Hashtable<String,String> keyValue){
		File file = new File(path);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				new SystemException("创建文件异常: " +path);
				e.printStackTrace();
			}
		}
		return setValueAndStore(path, keyValue,"创建属性文件: " + file.getName());
	}
	
	/**
	 * @描述:<p>设置属性值</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:42:21
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件(包括类路径)
	 * @param key	属性键
	 * @param value	属性值
	 * @return
	 */
	public final static boolean setValue(String path, String key, String value){
		Properties properties = getProperties(path);
		if(properties == null){
			return false;
		}
		properties.put(key, value);
		return true;
	}
	
	/**
	 * @描述:<p>保存属性文件对象</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:48:02
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param properties	属性文件对象
	 * @param path			要保存的路径
	 * @param msg			保存时添加的附加信息（注释）
	 */
	public final static void store(Properties properties, String path, String msg){
		try {
			OutputStream os = new FileOutputStream(path);
			properties.store(os, msg);
		} catch (FileNotFoundException e) {
			log.error("FileOutputStream(" + path + ")! FileNotFoundException: " + e);
			new SystemException("没有找到文件路径: " + path);
		}catch (IOException e) {
			log.error("store(stream, msg)! IOException: " + e);
			new SystemException("保存属性文件对象 !IOException" +e);
		}
	}
	/**
	 * @描述:<p>删除属性值</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:51:34
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件(包括类路径)
	 * @param key	属性键
	 * @return
	 */
	public final static String removeValue(String path, String key){
		Properties properties = getProperties(path);
		if(properties == null){
			return null;
		}
		return (String)properties.remove(key);
	}
	/**
	 * @描述:<p>删除属性文件中的Key数组所对应的键值对  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:55:27
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件路径(包括类路径及文件系统路径)
	 * @param keys	key数组
	 * @return		属性文件对象
	 */
	public final static Properties removeValue(String path, String[] keys){
		if(keys == null){
			log.error("keys[] 为空!");
			return null;
		}
		Properties properties = getProperties(path);
		if(properties == null){
			return null;
		}
		for(String key : keys){
			properties.remove(key);
		}
		return properties;
	}

	/**
	 * @描述:<p>删除属性文件中的Key数组所对应的键值对，并将属性文件对象持久化（即保存）</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:56:50
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	属性文件路径(包括类路径及文件系统路径)
	 * @param key	属性文件中的key数组
	 * @return		成功与否（true|false）
	 */
	public final static boolean removeValueAndStore(String path, String[] key) {
		Properties properties = removeValue(path, key);
		if (properties == null) {
			return false;
		}
		store(properties, path, "batch remove key value!");
		return true;
	}

	/**
	 * @描述:<p>更新指定路径的属性文件中的键所对应的值</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午09:58:16
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path 		属性文件路径(包括类路径及文件系统路径)
	 * @param key		属性文件中的key
	 * @param newValue	要更新的新值
	 * @return			成功与否（true|false）
	 */
	public final static boolean updateValue(String path,String key, String newValue) {
		if (key == null || newValue == null) {
			log.error("key or newValue is null!");
			return false;
		}
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
		hashtable.put(key, newValue);
		return setValueAndStore(path, hashtable, "update " + key + "'s value!");
	}
	
	/**
	 * @描述:<p>批量更新指定路径的属性文件中的键所对应的值  </p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午10:00:41
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path		属性文件路径(包括类路径及文件系统路径)
	 * @param keyValue	要更新的键值对Hashtable
	 * @return			成功与否（true|false）
	 */
	public final static boolean batchUpdateValue(String path,Hashtable<String, String> keyValue) {
		if (path == null || keyValue == null) {
			return false;
		}
		return setValueAndStore(path, keyValue, "batch update key value!");
	}
	
	  /**
	 * @描述:<p>移除加载的属性文件</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午10:01:41
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path 属性文件(包括类路径)
	 * @return
	 */
	public final static Properties removePropertyFile(String path) {
		return hashtable.remove(path);
	}
	/**
	 * @描述:<p>重新加载某个Property文件</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午10:03:32
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param path	要重新加载的Property文件，如果当前内存中没有的话则加载，否则替换
	 */
	public final static void reloadPropertyFile(String path){
		hashtable.remove(path);
		loadPropertyFile(path);
	}
	 /**
	 * @描述:<p>获得属性文件的路径</p>
	 *
	 * @作者:  叶平平(yepp)
	 *
	 * @时间:  2012-1-14 下午10:04:58
	 *
	 * @修改历史: <p>修改时间、修改人、修改原因/说明</p>
	 *
	 * @param pkg		包名
	 * @param fileName 	属性文件名 
	 * @return
	 */
	public final static String getPpropertyFilePath(String pkg, String fileName) {
	    pkg = pkg == null ? "" : pkg.replaceAll("\\.", "/");
	    fileName = fileName.endsWith(".properties") ? fileName : (fileName + ".properties");
	    return "/" + pkg + "/" + fileName;
	  }
	 public static void main(String[] args) {
		    String path = "/config/jdbc.properties";
		    String v = PropertiesUtil.getValue(path, "jdbc.driverClassName");
		    log.info("value0 = " + v);

		    Hashtable<String, String> ht = new Hashtable<String, String>();
		    ht.put("name", "dengcd");
		    PropertiesUtil.setValueAndStore(path, ht);
		    String v_ = PropertiesUtil.getValue(path, "name");
		    log.info("value1 = " + v_);
		    PropertiesUtil.reloadPropertyFile(path);
		    String v2_ = PropertiesUtil.getValue(path, "name");
		    log.info("value2 = " + v2_);
		  }
}
