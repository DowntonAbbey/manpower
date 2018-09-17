package com.qf.metting.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginAututicationFilter implements Filter {
	private String[] noInterceptor = { "/index.jsp", "/loginForm.jsp", "/UserServlet?method='login'" };

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		// 判断不需要拦截的数据
		// 对路径进行处理
		String requestUrl = req.getRequestURI();
		// 获取最后的访问路径
		String[] paths = requestUrl.split("/");

		// 释放静态资源
		if (requestUrl.endsWith(".css") || requestUrl.endsWith(".jpg") || requestUrl.endsWith(".js")
				|| requestUrl.endsWith(".png")) {
			chain.doFilter(request, response);
			return;
		}
		//释放登录资源
		try {
			String data = request.getParameter("method");
			if (data.equals("login")) {
				chain.doFilter(request, response);
				return;
			}
		} catch (Exception e) {

		}
		// 判断需要拦截的数据
		boolean b = jugmentIntercept(paths[paths.length - 1]);

		if (!b) {
			chain.doFilter(req, res);
			return;
		} else {
			boolean tag = jumgmentUserLoginState(req);
			if (tag) {
				chain.doFilter(req, res);
				return;
			} else {
				req.getRequestDispatcher("/view/loginForm.jsp").forward(req, res);
				//res.sendRedirect("/view/loginForm.jsp");
			}

		}

	}

	/**
	 * 判断不需要拦截的数据 @Title: initIntercept @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param request @param @param
	 * response @param @param chain @param @param req @param @return @param @throws
	 * IOException @param @throws ServletException 设定文件 @return String 返回类型 @throws
	 */
	

	/**
	 * 判断用户是否登录过 @Title: jumgmentUserLoginState @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param req @param @return 设定文件 @return boolean
	 * 返回类型 @throws
	 */
	private boolean jumgmentUserLoginState(HttpServletRequest req) {
		HttpSession httpSession = req.getSession();
		String backUser = (String) httpSession.getAttribute("backUser");
		if (null != backUser && !"".equals(backUser)) {
			return true;
		}
		return false;

	}

	private boolean jugmentIntercept(String requestUrl) {
		for (String path : noInterceptor) {
			// 地址不需要拦截
			if (requestUrl.equals(path)) {
				return false;
			}
		}
		return true;
	}

}
