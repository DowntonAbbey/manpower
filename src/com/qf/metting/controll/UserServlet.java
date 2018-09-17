package com.qf.metting.controll;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.qf.metting.pojo.User;
import com.qf.metting.service.impl.IUserService;
import com.qf.metting.utils.BeanContainerUtils;
import com.qf.metting.utils.PageUtils;
import com.qf.metting.utils.ParamesObjectUtils;
import com.qf.metting.utils.UserInfoUtils;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = null;
	
	{
		try {
			userService = (IUserService) BeanContainerUtils.getBean("IUserService");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("对象实例化失败");
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			//封装获取的参数
			User user = ParamesObjectUtils.getObject(request, User.class);
			//得到需要访问的方法
			String methodName = request.getParameter("method");
			//判断方法
			jumgementMethod(methodName,request,response,user);
		} catch (Exception e) {
			System.out.println("请求出现了问题");
		}
	}

	private void jumgementMethod(String methodName, HttpServletRequest request, HttpServletResponse response,User user) {
		//登录
		if("login".equals(methodName)) {
			//调用登录的业务逻辑
			User user2;
			try {
				user2 = userService.login(user);
				if(user2 != null) {
					setSessionData(request,user2);
					PageUtils.jumpPage(request, response,"/view/main.jsp");
				}
			}
			catch (Exception e) {
				System.out.println(e);
				try {
					response.sendRedirect(request.getContextPath()+"/view/loginForm.jsp");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		//查找所有用户
		else if("findUserAll".equals(methodName)) {
			List<User> users=null;
			try {
				users = userService.findUserAll();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("连接数据库失败");
			}
			if(users==null) {
				System.out.println("查询所有用户的数据为空");
			}else {
				
				request.setAttribute("users", users);
				try {
					PageUtils.jumpPage(request, response,"/view/user/user.jsp");
				} catch (ServletException | IOException e) {
					System.out.println("跳转到user.jsp页面失败");
					e.printStackTrace();
				}
			}
		}
		//查询用户
		else if("search".equals(methodName)) {
			List<User> users = null;
			if(!"".equals(user.getUserName()) && 0 == user.getState()) {
				try {
					users = userService.findUserByName(user.getUserName());
				} catch (SQLException e) {
					System.out.println("通过用户名模糊查询失败");
					e.printStackTrace();
				}
			}
			else if("".equals(user.getUserName()) && 0 != user.getState()) {
				try {
					users =userService.findUserByState(user.getState());
				} catch (SQLException e) {
					System.out.println("通过状态查询用户失败");
					e.printStackTrace();
				}
			}
			else if(!"".equals(user.getUserName()) && 0 != user.getState()) {
				try {
					users = userService.findUserByNameAndState(user.getUserName(), user.getState());
				} catch (SQLException e) {
					System.out.println("通过用户名和状态查询用户失败");
					e.printStackTrace();
				}
			}
			else {
				System.out.println("传入的参数不对");
			}
			if(users==null) {
				System.out.println("没有查询到用户");
			}
			request.setAttribute("users", users);
			try {
				PageUtils.jumpPage(request, response,"/view/user/user.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
		//添加用户
		else if("addUser".equals(methodName)) {
			//调用添加业务逻辑
			user.setEmpName(user.getUserName());
			user.setCreateTime(new Date());
			user.setState(1);
			try {
				userService.add(user);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("用户添加失败");
			}
			
			try {
				PageUtils.jumpPage(request, response,"/UserServlet?method=findUserAll");
			} catch (ServletException | IOException e) {
				System.out.println("跳转到use.jsp页面失败");
				e.printStackTrace();
			}
			
		}
		//删除用户
		else if("deleteUser".equals(methodName)) {
			String ids = request.getParameter("ids");
			String[] idsStr = ids.split(",");
			for(String str:idsStr) {
				int empId = Integer.parseInt(str);
				user.setUserId(empId);
				try {
					userService.deleteUser(user);
				} catch (SQLException e) {
					System.out.println("删除用户时，操作数据库出现问题");
					e.printStackTrace();
				}
			}
			try {
				PageUtils.jumpPage(request, response,"/UserServlet?method=findUserAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//初始化修改数据
		else if("findUserById".equals(methodName)) {
			User user2=null;
			try {
				user2 = userService.finUserById(user);
			} catch (SQLException e) {
				System.out.println("执行查询操作异常");
				e.printStackTrace();
			}
			if(user2==null) {
				throw new RuntimeException("通过id查询用户为空");
			}
			request.setAttribute("user", user2);
			try {
				PageUtils.jumpPage(request, response,"/view/user/showUpdateUser.jsp");
			} catch (ServletException | IOException e) {
				System.out.println("跳转到showUpdateUser.jsp页面失败");
				e.printStackTrace();
			}
		}
		//修改用户数据
		else if("updateUser".equals(methodName)) {
			try {
				user.setCreateTime(new Date());
				userService.updateUser(user);
			} catch (SQLException e) {
				System.out.println("修改用户失败");
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response,"/UserServlet?method=findUserAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		//用户注销
		else if("loginout".equals(methodName)) {
			
			try {
				request.getRequestDispatcher("/view/loginForm.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
	/**
	 * @throws UnsupportedEncodingException 
	 * 将user保存到session中
	 * @Title: setSessionData 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param request
	 * @param @param user2    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void setSessionData(HttpServletRequest request, User user2) throws UnsupportedEncodingException {
		//用户密码设置为空
		user2.setPassword("");
		//将user保存在session中
		HttpSession session = request.getSession();
		session.setAttribute("backUser", UserInfoUtils.getBase64(user2.toString()));
		session.setAttribute("userLogin", user2);
	}

}
