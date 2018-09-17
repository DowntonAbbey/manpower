package com.qf.metting.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这个是字符编码的过滤器
 * @ClassName:  ChacterFilter   
 * @Description:TODO   
 * @author: xiaobobo
 * @date:   2018-8-30 上午11:19:06   
 *     
 * @Copyright: 2018 
 *
 */
public class ChacterFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//将上面的请求和相应转换成和HTTP相关的
		final HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		//第二步:先解决返回数据的编码问题
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//接下来要监听 HttpServletRequest中 getParameter方法的执行(动态代理)
		HttpServletRequest requestProxy=(HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(),
				new Class[]{HttpServletRequest.class},
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						   
						    //看看是不是getParameter方法在执行
						    String methodName=method.getName();
						    if("getParameter".equals(methodName)){  //说明是getParameter方法
						    	//看看是GET呢还是POST呢?
						    	String reqName=req.getMethod();
						    	//判断
						    	if("get".equalsIgnoreCase(reqName)){ //说明是GET方法
						    		//第一步:获取方法执行的结果
						    		String val=(String) method.invoke(req, args);
						    		//第二步:进行编码处理
						    		val = new String(val.getBytes("ISO-8859-1"),"UTF-8");
						    		return val;
						    	}else {
						    		return method.invoke(req, args);
						    	}
						    }else{  //说明请求的不是getParameter方法
						    	return method.invoke(req, args);
						    }
					}
		});
		
		//放行
		chain.doFilter(requestProxy, resp);
	}
	@Override
	public void destroy() {
		
		
	}
}
