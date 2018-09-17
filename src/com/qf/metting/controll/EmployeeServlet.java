package com.qf.metting.controll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.qf.metting.pojo.Dept;
import com.qf.metting.pojo.Employee;
import com.qf.metting.pojo.Staff;
import com.qf.metting.service.impl.IDeptService;
import com.qf.metting.service.impl.IEmployeeService;
import com.qf.metting.service.impl.IStaffService;
import com.qf.metting.utils.BeanContainerUtils;
import com.qf.metting.utils.PageUtils;
import com.qf.metting.utils.ParamesObjectUtils;


public class EmployeeServlet extends HttpServlet {
	private IEmployeeService employeeService;
	private IStaffService staffService;
	private IDeptService deptService;
	{
		try {
			employeeService = (IEmployeeService) BeanContainerUtils.getBean("IEmployeeService");
			staffService = (IStaffService) BeanContainerUtils.getBean("IStaffService");
			deptService = (IDeptService) BeanContainerUtils.getBean("IDeptService");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("对象实例化失败");
		}
		
	}
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		//获取请求的数据
		//获取请求的方法
		try {
			String method = request.getParameter("method");
			Employee employee = ParamesObjectUtils.getObject(request, Employee.class);
			jumgmentMethod(request, response, method, employee);
		} catch (Exception e1) {
			System.out.println("获取请求失败");
			e1.printStackTrace();
		}
		
	}

	private void jumgmentMethod(HttpServletRequest request, HttpServletResponse response, String method,Employee employee) {
		if("findEmpAll".equals(method)) {
			//调用逻辑层
			try {
				List<Employee> emps = employeeService.findEmpAll();
				String json = JSONObject.toJSONString(emps);
			
				try {
					response.getWriter().write(json);
					response.getWriter().flush();
					response.getWriter().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("查询所有员工失败");
			}
		}
		
		//查询所有员工
		else if("turnM".equals(method)) {
			List<Employee> employees=null;
			try {
				employees = employeeService.findEmpAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(employees == null) {
				System.out.println("查询所有员工结果为空");
			}
			empInit(request);
			request.setAttribute("employees", employees);
			
			try {
				PageUtils.jumpPage(request, response, "/view/employee/employee.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//添加员工页面初始化
		else if("turnAddEmp".equals(method)) {
			empInit(request);
			try {
				PageUtils.jumpPage(request, response, "/view/employee/showAddEmployee.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		//添加员工
		else if("addEmp".equals(method)) {
			getStaffAdnDept(employee);
			try {
				employeeService.addEmp(employee);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/emps?method=turnM");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//删除员工
		else if("deleteEmp".equals(method)) {
			String ids = request.getParameter("ids");
			String[] idsStr = ids.split(",");
			for(String str:idsStr) {
				int empId = Integer.parseInt(str);
				
				try {
					employeeService.deleteEmp(empId);
				} catch (SQLException e) {
					System.out.println("删除员工时，操作数据库出现问题");
					e.printStackTrace();
				}
			}
			try {
				PageUtils.jumpPage(request, response,"/emps?method=turnM");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		//初始化修改数据
		else if("findEmpById".equals(method)) {
			Employee employee2 = null;
			try {
				employee2 = employeeService.findEmpById(employee.getEmpId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(employee2==null) {
				System.out.println("查询结果为空");
			}
			empInit(request);
			request.setAttribute("employee", employee2);
			try {
				PageUtils.jumpPage(request, response, "/view/employee/showUpdateEmployee.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		//修改员工
		else if("updateEmp".equals(method)) {
			getStaffAdnDept(employee);
			try {
				employeeService.updateEmp(employee);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response,"/emps?method=turnM");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
		//模糊查询员工
		else if("search".equals(method)) {
			List<Employee> employees = null;
			try {
				employees = employeeService.findEmp(employee);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if(employees == null) {
				System.out.println("模糊查询员工数据为空");
			}
			request.setAttribute("employees", employees);
			empInit(request);
			try {
				PageUtils.jumpPage(request, response, "/view/employee/employee.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *    获取部门名和职位名
	 * @Title: getStaffAdnDept 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void getStaffAdnDept(Employee employee) {
		employee.setEmpCreateTime(new Date());
		try {
			int staffId = employee.getStaffId();
			Staff staff = staffService.finStaffById(staffId);
			employee.setStaffName(staff.getStaffName());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			int deptId = employee.getdId();
			Dept dept = deptService.findDeptById(deptId);
			employee.setDeptName(dept.getdName());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	/**
	 *   下拉列表数据初始化
	 * @Title: empInit 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param request    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void empInit(HttpServletRequest request) {
		List<Dept> depts = null;
		List<Staff> staffs = null;
		try {
			depts = deptService.findDeptAll();
			staffs = staffService.findStaffAll();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		request.setAttribute("depts", depts);
		request.setAttribute("staffs", staffs);
	}
	/**
	 *    获取部门名和职位名
	 * @Title: getStaffAdnDept 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param employee    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void getStaffAdnDeptList(Employee employee,HttpServletRequest request) {
		employee.setEmpCreateTime(new Date());
		List<Staff> staffs =null;
		List<Dept>  depts = null;
		try {
			int staffId = employee.getStaffId();
			Staff staff = staffService.finStaffById(staffId);
			employee.setStaffName(staff.getStaffName());
			staffs.add(staff);
			request.setAttribute("staffs", staffs);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			int deptId = employee.getdId();
			Dept dept = deptService.findDeptById(deptId);
			employee.setDeptName(dept.getdName());
			depts.add(dept);
			request.setAttribute("depts", depts);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	

}
