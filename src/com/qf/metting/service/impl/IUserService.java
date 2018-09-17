package com.qf.metting.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.User;

public interface IUserService {
	void add(User user) throws SQLException;
	/**
	 * 	更新用户
	 * @Title: update 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param user
	 * @param @throws SQLException    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void update(User user) throws SQLException;
	/**
	 * 	通过姓名查找用户
	 * @Title: findUserByName 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param username
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<User>    返回类型 
	 * @throws
	 */
	List<User> findUserByName(String username)throws SQLException;
	/**
	 * 	通过状态查找用户
	 * @Title: findUserByState 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param State
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<User>    返回类型 
	 * @throws
	 */
	List<User> findUserByState(int State)throws SQLException;
	/**
	 * 	通过用户名和状态查找用户
	 * @Title: findUserByNameAndState 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param username
	 * @param @param State
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<User>    返回类型 
	 * @throws
	 */
	List<User> findUserByNameAndState(String username,int State) throws SQLException;
	/**
	 * 查看登录是否成功
	 * @Title: login 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param user
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	User login(User user) throws Exception;
	/**
	 * 通过员工姓名精确查找员工对象
	 * @Title: finUserByNameAccurate 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	User finUserByNameAccurate(User user) throws Exception;
	/**
	 * @throws SQLException 
	 * 查找所有用户
	 * @Title: findUserAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return List<User>    返回类型 
	 * @throws
	 */
	List<User> findUserAll() throws SQLException;
	/**
	 * @throws SQLException 
	 * 通过id查找用户
	 * @Title: finUserById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param user
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	User finUserById(User user) throws SQLException;
	/**
	 * 通过idx修改用户
	 * @Title: updateUser 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param user
	 * @param @throws SQLException    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateUser(User user) throws SQLException;
	/**
	 * @throws SQLException 
	 * 删除用户
	 * @Title: deleteUser 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param user    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void deleteUser(User user) throws SQLException;

}
