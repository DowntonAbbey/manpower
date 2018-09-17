package com.qf.metting.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Staff;

public interface IStaffDAO extends IBaseDAO<Staff>{
	//添加职位
	void add(Staff staff) throws SQLException;
	//通过名字进行查询
	List<Staff> findStaffByName(String staffName) throws SQLException;
	//修改职位
	void updateStaff(Staff staff) throws SQLException;
}
