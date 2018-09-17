package com.qf.metting.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Dept;

public interface IDeptDAO extends IBaseDAO<Dept>{
	//添加部门
	void add(Dept dept) throws SQLException;
	//通过名字查询
	List<Dept> findDeptByDName(String dName) throws SQLException;
	//通过部门Id修改
	public void updateDept(Dept dept) throws SQLException;
}
