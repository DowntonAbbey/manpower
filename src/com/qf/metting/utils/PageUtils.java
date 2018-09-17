package com.qf.metting.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageUtils {
	public static void jumpPage(HttpServletRequest request,HttpServletResponse response,String pageUrl) throws ServletException, IOException {
		request.getRequestDispatcher(pageUrl).forward(request, response);
		
	}
}
