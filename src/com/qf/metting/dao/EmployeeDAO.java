package com.qf.metting.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.metting.dao.impl.IEmployeeDAO;
import com.qf.metting.pojo.Employee;


public class EmployeeDAO extends BaseDAO<Employee> implements IEmployeeDAO{

	public EmployeeDAO() {
		super("t_emp");
	}

	@Override
	public void addEmp(Employee employee) throws SQLException {
		getQueryRunner().update("insert into t_emp(empName, gender, telNum, email, staffName, empEdu, "
				+ "cardNum, deptName, empAddress, empCreateTime, staffId, phone, political, qq, ems, "
				+ "birth, volk, major, habiit, remark, dId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?)" ,  employee.getEmpName(), employee.getGender(), employee.getTelNum(), 
				employee.getEmail(), employee.getStaffName(), employee.getEmpEdu(), employee.getCardNum(),
				employee.getDeptName(), employee.getEmpAddress(), employee.getEmpCreateTime(), 
				employee.getStaffId(), employee.getPhone(), employee.getPolitical(), employee.getQq(), 
				employee.getEms(), employee.getBirth(), employee.getVolk(), employee.getMajor(), 
				employee.getHabiit(), employee.getRemark(), employee.getdId());
	}

	@Override
	public void updateEmp(Employee employee) throws SQLException {
		getQueryRunner().update("update t_emp set empName=?, gender=?, telNum=?, email=?, staffName=?, empEdu=?, "
				+ "cardNum=?, deptName=?, empAddress=?, empCreateTime=?, staffId=?, phone=?, political=?, qq=?, "
				+ "ems=?, birth=?, volk=?, major=?, habiit=?, remark=?, dId = ? where empId=?",
				employee.getEmpName(), employee.getGender(), employee.getTelNum(), 
				employee.getEmail(), employee.getStaffName(), employee.getEmpEdu(), employee.getCardNum(),
				employee.getDeptName(), employee.getEmpAddress(), employee.getEmpCreateTime(), 
				employee.getStaffId(), employee.getPhone(), employee.getPolitical(), employee.getQq(), 
				employee.getEms(), employee.getBirth(), employee.getVolk(), employee.getMajor(), 
				employee.getHabiit(), employee.getRemark(), employee.getdId(),employee.getEmpId());
	}

	@Override
	public List<Employee> findEmp(String staffName, String gender, String empName, String telNum, String cardNum,
			String deptName) throws SQLException {
		return getQueryRunner().query("select * from t_emp where staffName like ? and gender like ? and empName like ? and telNum like ? and cardNum like ? and deptName like ?", new BeanListHandler<Employee>(Employee.class),"%"+staffName+"%","%"+gender+"%","%"+empName+"%","%"+telNum+"%","%"+cardNum+"%","%"+deptName+"%");
	}
	
	@Override
	public List<Employee> findEmp(String staffName, String empName, String telNum, String cardNum,
			String deptName) throws SQLException {
		return getQueryRunner().query("select * from t_emp where staffName like ?  and empName like ? and telNum like ? and cardNum like ? and deptName like ?", new BeanListHandler<Employee>(Employee.class),"%"+staffName+"%","%"+empName+"%","%"+telNum+"%","%"+cardNum+"%","%"+deptName+"%");
	}


	


	
	
	
}
