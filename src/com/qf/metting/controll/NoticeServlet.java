package com.qf.metting.controll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qf.metting.pojo.Notice;
import com.qf.metting.pojo.User;
import com.qf.metting.service.impl.INoticeService;
import com.qf.metting.utils.BeanContainerUtils;
import com.qf.metting.utils.PageUtils;
import com.qf.metting.utils.ParamesObjectUtils;

public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private INoticeService noticeService;
	{
		try {
			noticeService = (INoticeService) BeanContainerUtils.getBean("INoticeService");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("noticeService对象实例化失败");
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try {
			Notice notice = ParamesObjectUtils.getObject(request, Notice.class);
			String method = request.getParameter("method");
			JumgmentMethod(request, response, notice, method);
		} catch (Exception e) {
			System.out.println("请求出现了问题");
			e.printStackTrace();
		}

	}

	private void JumgmentMethod(HttpServletRequest request, HttpServletResponse response, Notice notice,
			String method) {

		// 查询所有公告
		if ("findNoticeAll".equals(method)) {
			List<Notice> notices = null;
			try {
				notices = noticeService.findNoticeAll();
			} catch (SQLException e) {
				System.out.println("连接数据库失败");
				e.printStackTrace();
			}
			if (notices == null) {
				System.out.println("查询公告结果为空");
			}
			request.setAttribute("notices", notices);
			try {
				PageUtils.jumpPage(request, response, "/view/notice/notice.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		// 模糊查询公告
		else if ("search".equals(method)) {
			List<Notice> notices = null;
			if (!"".equals(notice.getNoticeTitle()) && "".equals(notice.getNoticeContent())) {
				try {
					notices = noticeService.findNoticeByTitle(notice);
				} catch (SQLException e) {
					System.out.println("通过公告名模糊查询失败");
					e.printStackTrace();
				}
			} else if ("".equals(notice.getNoticeTitle()) && !"".equals(notice.getNoticeContent())) {
				try {
					notices = noticeService.finNoticeByContent(notice);
				} catch (SQLException e) {
					System.out.println("通过公告内容查询失败");
					e.printStackTrace();
				}
			} else if (!"".equals(notice.getNoticeTitle()) && !"".equals(notice.getNoticeContent())) {
				try {
					notices = noticeService.finNoticeByTitleAndContent(notice);
				} catch (SQLException e) {
					System.out.println("通过公告名和内容查询失败");
					e.printStackTrace();
				}
			} else {
				System.out.println("传入的参数不对");
			}
			if (notices == null) {
				System.out.println("没有查询到公告");
			}
			request.setAttribute("notices", notices);
			try {
				PageUtils.jumpPage(request, response, "/view/notice/notice.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		// 预览
		else if ("previewNotice".equals(method)) {
			Notice notice2 = null;
			try {
				notice2 = noticeService.findNoticeById(notice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("notice", notice2);
			try {
				PageUtils.jumpPage(request, response, "/view/notice/previewNotice.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		// 添加公告
		else if ("addNotice".equals(method)) {
			// 设置时间
			notice.setNoticeTime(new Date());
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("userLogin");
			notice.setUserId(user.getUserId());
			notice.setNoticeUser(user.getUserName());
			try {
				noticeService.addNotice(notice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "/notices?method=findNoticeAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

		// 删除公告
		else if ("deleteNotice".equals(method)) {
			String ids = request.getParameter("ids");
			String[] idsStr = ids.split(",");
			for (String str : idsStr) {
				int noticeId = Integer.parseInt(str);
				notice.setNoticeId(noticeId);
				try {
					noticeService.deleteNotice(notice);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				PageUtils.jumpPage(request, response, "/notices?method=findNoticeAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		//修改公告初始化
		else if ("findNoticeById".equals(method)) {
			Notice notice2 = null;
			try {
				notice2 = noticeService.findNoticeById(notice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("notice", notice2);
			try {
				PageUtils.jumpPage(request, response, "/view/notice/showUpdateNotice.jsp");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		//修改公告
		else if("updateNotice".equals(method)) {
			try {
				noticeService.updateNotice(notice);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				PageUtils.jumpPage(request, response, "notices?method=findNoticeAll");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}

	}

}
