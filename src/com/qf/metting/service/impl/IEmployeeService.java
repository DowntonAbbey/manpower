package com.qf.metting.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Employee;

public interface IEmployeeService {
	List<Employee> findEmpAll() throws SQLException;
	/**
	 * @throws SQLException 
	 *  添加员工
	 * @Title: addEmp 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void addEmp(Employee employee) throws SQLException;
	/**
	 * @throws SQLException 
	 *  通过id删除员工
	 * @Title: deleteEmp 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param empId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void deleteEmp(int empId) throws SQLException;
	/**
	 * @throws SQLException 
	 * 通过id查找员工
	 * @Title: findEmpById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param empId
	 * @param @return    设定文件 
	 * @return Employee    返回类型 
	 * @throws
	 */
	Employee findEmpById(int empId) throws SQLException;
	/**
	 * @throws SQLException 
	 *   修改员工
	 * @Title: updateEmp 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateEmp(Employee employee) throws SQLException;
	/**
	 * @throws SQLException 
	 * 模糊查询员工
	 * @Title: findEmp 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee
	 * @param @return    设定文件 
	 * @return List<Employee>    返回类型 
	 * @throws
	 */
	List<Employee> findEmp(Employee employee) throws SQLException;

}
