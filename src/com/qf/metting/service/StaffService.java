package com.qf.metting.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.dao.StaffDAO;
import com.qf.metting.dao.impl.IStaffDAO;
import com.qf.metting.pojo.Staff;
import com.qf.metting.service.impl.IStaffService;
import com.qf.metting.utils.BeanContainerUtils;

public class StaffService implements IStaffService{
	
	private IStaffDAO staffDAO = null;
	{
		try {
			staffDAO = (StaffDAO) BeanContainerUtils.getBean("IStaffDAO");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public void add(Staff staff) throws SQLException {
		if("".equals(staff.getStaffName())||"".equals(staff.getStaffDes())) {
			throw new RuntimeException("职位名或职位描述为空");
		}
		staffDAO.add(staff);
	}

	@Override
	public List<Staff> findStaffByName(String staffName) throws SQLException {
		
		if("".equals(staffName)) {
			throw new RuntimeException("职员名为空");
		}
		return staffDAO.findStaffByName(staffName);
	}

	@Override
	public void updateStaff(Staff staff) throws SQLException {
		if(staff.getStaffId()<=0) {
			throw new RuntimeException("职位id有误");
		}
		staffDAO.updateStaff(staff);
		
	}

	@Override
	public List<Staff> findStaffAll() throws SQLException {
		return staffDAO.findAll();
	}

	@Override
	public Staff finStaffById(Staff staff) throws SQLException {
		return staffDAO.findTById("t_staff",staff.getStaffId(), "staffId");
	}

	@Override
	public void deleteStaff(Staff staff) throws SQLException {
		staffDAO.deleteById(staff.getStaffId(), "staffId");
	}

	@Override
	public Staff finStaffById(int staffId) throws SQLException {
		return staffDAO.findTById("t_staff",staffId, "staffId");
		
	}

}
