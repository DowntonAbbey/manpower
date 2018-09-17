package com.qf.metting.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Employee;

public interface IEmployeeDAO extends IBaseDAO<Employee>{

	/**
	 *   添加员工
	 * @Title: addEmp 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee
	 * @param @throws SQLException    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void addEmp(Employee employee) throws SQLException;

	/**
	 * @throws SQLException 
	 *   修改员工表
	 * @Title: updateEmp 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateEmp(Employee employee) throws SQLException;
	/**
	 * @throws SQLException 
	 *  查询员工
	 * @Title: findEmp 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	List<Employee> findEmp(String staffName, String gender, String empName, String telNum, String cardNum,
			String deptName) throws SQLException;

	List<Employee> findEmp(String staffName, String empName, String telNum, String cardNum, String deptName)
			throws SQLException;
}
