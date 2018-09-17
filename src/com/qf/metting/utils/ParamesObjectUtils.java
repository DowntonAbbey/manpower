package com.qf.metting.utils;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;


/**
 * 封装请求的参数
 * @ClassName: ParamesObjectUtils 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年9月3日 下午4:21:26
 */
public class ParamesObjectUtils {
	public static <T> T getObject(HttpServletRequest request,Class<T> clazz) throws Exception {
		T t = clazz.newInstance();
		BeanUtils.populate(t, request.getParameterMap());
		return t;
	}
}
