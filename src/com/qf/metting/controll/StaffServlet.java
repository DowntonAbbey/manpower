package com.qf.metting.controll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.metting.pojo.Staff;
import com.qf.metting.service.impl.IStaffService;
import com.qf.metting.utils.BeanContainerUtils;
import com.qf.metting.utils.PageUtils;
import com.qf.metting.utils.ParamesObjectUtils;




public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IStaffService staffService;
    {
    	try {
			staffService = (IStaffService) BeanContainerUtils.getBean("IStaffService");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("staffService对象实例化失败");
			e.printStackTrace();
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		try {
			Staff staff = ParamesObjectUtils.getObject(request, Staff.class);
			String method = request.getParameter("method");
			JumgmentMethod(request,response,method,staff);
		} catch (Exception e) {
			System.out.println("实例化staff对象失败");
			e.printStackTrace();
		}
	}

	private void JumgmentMethod(HttpServletRequest request, HttpServletResponse response, String method, Staff staff) {
		//查询职位
		if("findStaffAll".equals(method)) {
			List<Staff> staffs = null;
			try {
				staffs = staffService.findStaffAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(staffs==null) {
				System.out.println("职位查询结果为空");
			}
			request.setAttribute("staffs", staffs);
			try {
				PageUtils.jumpPage(request, response, "/view/job/job.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//根据职位名查找职位
		else if("findStaffByName".equals(method)) {
			List<Staff> staffs = null;
			try {
				staffs = staffService.findStaffByName(staff.getStaffName());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(staffs==null) {
				System.out.println("职位查询结果为空");
			}
			request.setAttribute("staffs", staffs);
			try {
				PageUtils.jumpPage(request, response, "view/job/job.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//添加职位
		else if("addStaff".equals(method)) {
			try {
				staffService.add(staff);
			}catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/staffs?method=findStaffAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//初始化修改数据
		else if("findStaffById".equals(method)) {
			Staff staff2 = null;
			try {
				staff2 = staffService.finStaffById(staff);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("job", staff2);
			try {
				PageUtils.jumpPage(request, response, "/view/job/showUpdateJob.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//修改职位
		else if("updateStaff".equals(method)) {
			try {
				staffService.updateStaff(staff);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/staffs?method=findStaffAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		//删除职位
		else if("deleteStaff".equals(method)) {
			String ids = request.getParameter("ids");
			String[] idsStr = ids.split(",");
			for(String str:idsStr) {
				int staffId = Integer.parseInt(str);
				staff.setStaffId(staffId);
				try {
					staffService.deleteStaff(staff);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				PageUtils.jumpPage(request, response, "/staffs?method=findStaffAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
