package com.qf.metting.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.dao.impl.IEmployeeDAO;
import com.qf.metting.pojo.Employee;
import com.qf.metting.service.impl.IEmployeeService;
import com.qf.metting.utils.BeanContainerUtils;

public class EmployeeService implements IEmployeeService{

	private IEmployeeDAO employeeDAO;
	{
		try {
			employeeDAO = (IEmployeeDAO) BeanContainerUtils.getBean("IEmployeeDAO");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("employeeDAO对象实例化失败");
		}
	}
	@Override
	public List<Employee> findEmpAll() throws SQLException {
		return employeeDAO.findAll();
	}
	@Override
	public void addEmp(Employee employee) throws SQLException {
		employeeDAO.addEmp(employee);
	}
	@Override
	public void deleteEmp(int empId) throws SQLException {
		employeeDAO.deleteById(empId, "empId");
	}
	@Override
	public Employee findEmpById(int empId) throws SQLException {
		return employeeDAO.findTById("t_emp", empId, "empId");
	}
	@Override
	public void updateEmp(Employee employee) throws SQLException {
		employeeDAO.updateEmp(employee);
		
	}
	@Override
	public List<Employee> findEmp(Employee employee) throws SQLException {
		if(null == employee.getCardNum()) {
			employee.setCardNum("");
		}
		if(null == employee.getTelNum()) {
			employee.setTelNum("");
		}
		return employeeDAO.findEmp(employee.getStaffName(),employee.getGender(),employee.getEmpName(),employee.getTelNum(),employee.getCardNum(),employee.getDeptName());
	}

}
