package com.qf.metting.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
/**
 * 	所有dao的基接口
 * @ClassName: IBaseDAO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午9:42:01 
 * @param <T>
 */
public interface IBaseDAO<T> {
	/**
	 * @throws SQLException 
	 * 	查找所有
	 * @Title: findAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return List<T>    返回类型 
	 * @throws
	 */
	List<T> findAll() throws SQLException;
	/**
	 *	插入数据
	 * @Title: add 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param params    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void add(Object... params);
	
	/**
	 * @throws SQLException 
	 * 	通过id删除
	 * @Title: deleteById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param id    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void deleteById(Serializable id, String idName) throws SQLException;
	/**
	 * @throws SQLException 
	 * 	通过id找内容
	 * @Title: findTById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param tabName
	 * @param @param id
	 * @param @param idName
	 * @param @return    设定文件 
	 * @return T    返回类型 
	 * @throws
	 */
	T findTById(String tabName, Serializable id, String idName) throws SQLException;
	
}
