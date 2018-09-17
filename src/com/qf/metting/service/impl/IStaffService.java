package com.qf.metting.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Staff;

public interface IStaffService {

	// 添加职位
	void add(Staff staff) throws SQLException;

	// 通过名字进行查询
	List<Staff> findStaffByName(String staffName) throws SQLException;

	// 修改职位
	void updateStaff(Staff staff) throws SQLException;
	/**
	 * @throws SQLException 
	 * 添加职位
	 * @Title: findStaffAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return List<Staff>    返回类型 
	 * @throws
	 */
	List<Staff> findStaffAll() throws SQLException;
	/**
	 * @throws SQLException 
	 * 通过id查找职位
	 * @Title: finStaffById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param staffId
	 * @param @return    设定文件 
	 * @return Staff    返回类型 
	 * @throws
	 */
	Staff finStaffById(Staff staff) throws SQLException;
	/**
	 * @throws SQLException 
	 * 通过id删除职位
	 * @Title: deleteStaff 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param staff    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void deleteStaff(Staff staff) throws SQLException;

	Staff finStaffById(int staffId) throws SQLException;
}
