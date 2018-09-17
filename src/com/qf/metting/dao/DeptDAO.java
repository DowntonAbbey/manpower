package com.qf.metting.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.metting.dao.impl.IDeptDAO;
import com.qf.metting.pojo.Dept;


public class DeptDAO extends BaseDAO<Dept> implements IDeptDAO{
	public DeptDAO() {
		super("t_dept");
	}

	@Override
	public void add(Dept dept) throws SQLException {
		
		getQueryRunner().update("insert into t_dept(dName,dDes) values(?,?)",dept.getdName(),dept.getdDes());
	}

	@Override
	public List<Dept> findDeptByDName(String dName) throws SQLException {
		
		return getQueryRunner().query("select * from t_dept where dName =?",new BeanListHandler<Dept>(Dept.class),dName);
	}

	@Override
	public void updateDept(Dept dept) throws SQLException {
		getQueryRunner().update("update t_dept set dName=?,dDes=? where dId = ?",dept.getdName(),dept.getdDes(),dept.getdId());
	}

}
