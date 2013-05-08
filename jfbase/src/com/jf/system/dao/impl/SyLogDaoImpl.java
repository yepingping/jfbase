package com.jf.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.jf.framework.dao.BaseDaoImpl;
import com.jf.system.dao.SyLogDao;
import com.jf.system.model.SyLog;

/**
 * @描述:<p>日志Dao实现类</p>
 *
 * @作者: 叶平平(yepp)
 *
 * @时间: 2013-5-8 下午12:20:01
 */
@Repository("syLogDao")
public class SyLogDaoImpl extends BaseDaoImpl<SyLog> implements SyLogDao {

}
