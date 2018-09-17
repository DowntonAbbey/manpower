package com.qf.metting.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.metting.dao.impl.IStaffDAO;
import com.qf.metting.pojo.Staff;

public class StaffDAO extends BaseDAO<Staff> implements IStaffDAO{

	public StaffDAO() {
		super("t_staff");
		
	}

	@Override
	public void add(Staff staff) throws SQLException {
		getQueryRunner().update("insert into t_staff(staffName,staffDes) values(?,?)",staff.getStaffName(),staff.getStaffDes());
	}

	@Override
	public List<Staff> findStaffByName(String staffName) throws SQLException {
		
		return getQueryRunner().query("select * from t_staff where staffName like ?", new BeanListHandler<Staff>(Staff.class),staffName);
	}

	@Override
	public void updateStaff(Staff staff) throws SQLException {
		
		getQueryRunner().update("update t_staff set staffName=?,staffDes=? where staffId=?",staff.getStaffName(),staff.getStaffDes(),staff.getStaffId());
	}

}
