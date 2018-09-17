package com.qf.metting.service.impl;

import java.sql.SQLException;
import java.util.List;


import com.qf.metting.pojo.Dept;

public interface IDeptService {
	// 添加部门
	void add(Dept dept) throws SQLException;

	// 通过名字查询
	List<Dept> findDeptByDName(String dName) throws SQLException;

	// 通过部门Id修改
	public void updateDept(Dept dept) throws SQLException;
	/**
	 * @throws Throwable 
	 * 查询所有部门
	 * @Title: findDeptAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return List<dept>    返回类型 
	 * @throws
	 */
	List<Dept> findDeptAll() throws Throwable;
	/**
	 * @throws SQLException 
	 * 通过id查询部门
	 * @Title: findDeptById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param dept
	 * @param @return    设定文件 
	 * @return Dept    返回类型 
	 * @throws
	 */
	Dept findDeptById(Dept dept) throws SQLException;
	/**
	 * @throws SQLException 
	 * 删除部门
	 * @Title: deleteDept 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param dept    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void deleteDept(Dept dept) throws SQLException;
	/**
	 * @throws SQLException 
	 *  通过id 查找部门
	 * @Title: findDeptById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param deptId
	 * @param @return    设定文件 
	 * @return Dept    返回类型 
	 * @throws
	 */
	Dept findDeptById(int deptId) throws SQLException;
}
