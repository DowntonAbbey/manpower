package com.qf.metting.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.metting.dao.impl.IBaseDAO;
import com.qf.metting.utils.JdbcUtils;

/**
 * 	BaseDAO的实现
 * @ClassName: BaseDAO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午9:57:14 
 * @param <T>
 */
public class BaseDAO<T> implements IBaseDAO<T>{

	private Class<T> clazz;
	private String tabName;
	@SuppressWarnings("unchecked")
	public BaseDAO(String tabName) {
		this.tabName = tabName;
		ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		System.out.println("class的类型是："+clazz.getName());
	}
	
	QueryRunner getQueryRunner(){
		return JdbcUtils.getQueryRunner();
	}
	
	
	@Override
	public List<T> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return JdbcUtils.getQueryRunner().query("select * from "+tabName, new BeanListHandler<T>(clazz));
	}

	@Override
	public void add(Object... params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findTById(String tabName, Serializable id,String idName) throws SQLException {
		return JdbcUtils.getQueryRunner().query("select * from "+tabName+" where "+idName+"= ?",new BeanHandler<T>(clazz),id);
	}

	@Override
	public void deleteById(Serializable id,String idName) throws SQLException {
		// TODO Auto-generated method stub
		JdbcUtils.getQueryRunner().update("delete from "+tabName+" where "+idName+"=?",id);
	}

}
