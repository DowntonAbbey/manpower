package com.qf.metting.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.User;
/**
 * 
 * @ClassName: IUserDAO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午11:24:04 
 * @param <T>
 */
public interface IUserDAO<T> extends IBaseDAO<T>{
	/**
	 * 	添加用户
	 * @Title: add 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param user
	 * @param @throws SQLException    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
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
	List<User> findUserByState(int state)throws SQLException;
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
	List<User> findUserByNameAndState(String username,int state) throws SQLException;
	/**
	 * @throws Exception 
	 * 用户登录
	 * @Title: userLogin 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param userName
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	User userLogin(String userName) throws Exception;
	/**
	 * @throws SQLException 
	 * 通过用户名精确查找用户
	 * @Title: findUserByNameAccurate 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	User findUserByNameAccurate(String userName) throws SQLException;
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
	 * @Title: findUserById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param userId
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	User findUserById(int userId) throws SQLException;

}
