package com.qf.metting.controll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.metting.pojo.Dept;
import com.qf.metting.service.impl.IDeptService;
import com.qf.metting.utils.BeanContainerUtils;
import com.qf.metting.utils.PageUtils;
import com.qf.metting.utils.ParamesObjectUtils;

public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDeptService deptService;
	{
		try {
			deptService = (IDeptService) BeanContainerUtils.getBean("IDeptService");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("实例化deptService对象失败");
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		try {
			Dept dept = ParamesObjectUtils.getObject(request, Dept.class);
			String method = request.getParameter("method");
			jumgmentMethod(request,response,dept,method);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jumgmentMethod(HttpServletRequest request, HttpServletResponse response, Dept dept, String method) {
		//查询所有部门
		if("findDeptAll".equals(method)) {
			List<Dept> depts=null;
			try {
				depts = deptService.findDeptAll();
			} catch (Throwable e) {
				System.out.println("操作数据库失败");
				e.printStackTrace();
			}
			if(depts == null) {
				System.out.println("查询部门结果为空");
			}
			request.setAttribute("depts", depts);
			try {
				PageUtils.jumpPage(request, response,"/view/dept/dept.jsp");
			} catch (ServletException | IOException e) {
				System.out.println("跳转到dept.jsp页面失败");
				e.printStackTrace();
			}
		}
		//通过名字查找部门
		else if("findDeptByName".equals(method)) {
			List<Dept> depts = null;
			try {
				depts = deptService.findDeptByDName(dept.getdName());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(depts==null) {
				System.out.println("查询结果为空");
			}
			request.setAttribute("depts", depts);
			try {
				PageUtils.jumpPage(request, response,"/view/dept/dept.jsp");
			} catch (ServletException | IOException e) {
				System.out.println("跳转到dept.jsp页面失败");
				e.printStackTrace();
			}
			
		}
		//通过id查找部门
		else if("findDeptById".equals(method)) {
			Dept dept2 = null;
			{
				try {
					dept2 = deptService.findDeptById(dept);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			request.setAttribute("dept", dept2);
			try {
				PageUtils.jumpPage(request, response, "/view/dept/showUpdateDept.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//修改部门
		else if("updateDept".equals(method)) {
			try {
				deptService.updateDept(dept);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/depts?method=findDeptAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//删除部门
		else if ("deleteDept".equals(method)) {
			String ids = request.getParameter("ids");
			String[] idsStr = ids.split(",");
			for(String str:idsStr) {
				int empId = Integer.parseInt(str);
				dept.setdId(empId);
				try {
					deptService.deleteDept(dept);
				} catch (SQLException e) {
					e.printStackTrace();
				} 
			}
			
			try {
				PageUtils.jumpPage(request, response, "/depts?method=findDeptAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//添加部门
		else if("addDept".equals(method)) {
			try {
				deptService.add(dept);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/depts?method=findDeptAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
