package com.qf.metting.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.dao.impl.IDeptDAO;
import com.qf.metting.pojo.Dept;
import com.qf.metting.service.impl.IDeptService;
import com.qf.metting.utils.BeanContainerUtils;

public class DeptService implements IDeptService{

	private IDeptDAO deptDAO = null;
	{
		try {
			deptDAO = (IDeptDAO)BeanContainerUtils.getBean("IDeptDAO");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("实例化对象出现问题.........");
		}
	}
	@Override
	public void add(Dept dept) throws SQLException {
		if("".equals(dept.getdName())||"".equals(dept.getdDes())) {
			throw new RuntimeException("部门参数有问题");
		}
		deptDAO.add(dept);
	}

	@Override
	public List<Dept> findDeptByDName(String dName) throws SQLException {
		if("".equals(dName)) {
			throw new RuntimeException("部门名为空");
		}
		return deptDAO.findDeptByDName(dName);
	}

	@Override
	public void updateDept(Dept dept) throws SQLException {
		if(dept.getdId()<=0) {
			throw new RuntimeException("部门ID有问题");
		}
		deptDAO.updateDept(dept);
		
	}

	@Override
	public List<Dept> findDeptAll() throws Throwable {
		return deptDAO.findAll();
	}

	@Override
	public Dept findDeptById(Dept dept) throws SQLException {
		return deptDAO.findTById("t_dept", dept.getdId(), "dId");
	}

	@Override
	public void deleteDept(Dept dept) throws SQLException {
		// TODO Auto-generated method stub
		deptDAO.deleteById(dept.getdId(), "dId");
	}

	@Override
	public Dept findDeptById(int deptId) throws SQLException {
		return deptDAO.findTById("t_dept", deptId, "dId");
	}

}
