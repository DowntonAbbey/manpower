package com.qf.metting.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.metting.dao.impl.IUserDAO;
import com.qf.metting.pojo.User;
/**
 * 	用户DAO的实现
 * @ClassName: UserDAO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午10:50:27
 */
public class UserDAO extends BaseDAO<User> implements IUserDAO<User> {

	public UserDAO() {
		super("t_user");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void add(User user) throws SQLException {
		getQueryRunner().update("insert into t_user(userName, password,state,empName,createTime,empId) values (?,?,?,?,?,?)",user.getUserName(),user.getPassword(),user.getState(),user.getEmpName(),user.getCreateTime(),user.getEmpId());
	}

	@Override
	public void update(User user) throws SQLException {
		getQueryRunner().update("update t_user set userName=?, password=?,state=?,createTime=? where userId=?",user.getUserName(),user.getPassword(),user.getState(),user.getCreateTime(),user.getUserId());
	}
	@Override
	public List<User> findUserByName(String username) throws SQLException {
		return getQueryRunner().query("select * from t_user where userName like ?",new BeanListHandler<User>(User.class),"%"+username+"%");
		
	}
	@Override
	public List<User> findUserByState(int State) throws SQLException {
		return getQueryRunner().query("select * from t_user where state=?", new BeanListHandler<User>(User.class),State);
	}
	@Override
	public List<User> findUserByNameAndState(String username, int State) throws SQLException {
		return getQueryRunner().query("select * from t_user where userName like ? and state=?",new BeanListHandler<User>(User.class),"%"+username+"%",State);
	}
	@Override
	public User userLogin(String userName) throws Exception {
		return getQueryRunner().query("select * from t_user where userName =?", new BeanHandler<User>(User.class),userName);
	}
	@Override
	public User findUserByNameAccurate(String userName) throws SQLException {
		return getQueryRunner().query("select * from t_user where userName =?", new BeanHandler<User>(User.class),userName);
	}
	@Override
	public List<User> findUserAll() throws SQLException {
		return getQueryRunner().query("select * from t_user", new BeanListHandler<User>(User.class));
	}
	@Override
	public User findUserById(int userId) throws SQLException {
		// TODO Auto-generated method stub
		return getQueryRunner().query("select * from t_user where userId=?", new BeanHandler<User>(User.class),userId);
	}
	
	
}
