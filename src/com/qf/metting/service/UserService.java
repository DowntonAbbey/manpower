package com.qf.metting.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.dao.impl.IUserDAO;
import com.qf.metting.pojo.User;
import com.qf.metting.service.impl.IUserService;
import com.qf.metting.utils.BeanContainerUtils;

public class UserService implements IUserService {

	private IUserDAO userDAO = null;
	{
		try {
			userDAO = (IUserDAO) BeanContainerUtils.getBean("IUserDAO");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("实例化对象出现问题.........");
		}
	}

	@Override
	public void add(User user) throws SQLException {
		if (!(user == null || ("").equals(user.getUserName()) || ("").equals(user.getPassword()) || user.getState() <= 0)) {
			userDAO.add(user);
		}
	}

	@Override
	public void update(User user) throws SQLException {

		if (user.getUserId() <= 0) {
			throw new RuntimeException("更新数据失败，id不合法");
		}
	}

	@Override
	public List<User> findUserByName(String username) throws SQLException {

		if (username.equals("")) {
			throw new RuntimeException("参数不对，不能查询");
		}
		return userDAO.findUserByName(username);
	}

	@Override
	public List<User> findUserByState(int state) throws SQLException {

		if (state <= 0) {
			throw new RuntimeException("状态不对，无法查询");
		}
		return userDAO.findUserByState(state);
	}

	@Override
	public List<User> findUserByNameAndState(String username, int state) throws SQLException {
		if (username.equals("") || state <= 0) {
			throw new RuntimeException("参数不对，无法根据名字和状态进行查询");
		}
		return userDAO.findUserByNameAndState(username, state);
	}

	@Override
	public User login(User user) throws Exception {
		if ("".equals(user.getUserName()) || "".equals(user.getPassword()) || user == null) {
			throw new RuntimeException("参数有误，不能进行登录");
		} 
		User user2 = (User) userDAO.userLogin(user.getUserName());
		if (user2.getPassword().equals(user.getPassword())) {
			return user2;
		} 
		return null;

	}

	@Override
	public User finUserByNameAccurate(User user) throws SQLException {
		return userDAO.findUserByNameAccurate(user.getUserName());
	}

	@Override
	public List<User> findUserAll() throws SQLException {
		return userDAO.findUserAll();
	}

	@Override
	public User finUserById(User user) throws SQLException {
		return userDAO.findUserById(user.getUserId());
	}

	@Override
	public void updateUser(User user) throws SQLException {
		userDAO.update(user);
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		userDAO.deleteById(user.getUserId(), "userId");
	}

}
