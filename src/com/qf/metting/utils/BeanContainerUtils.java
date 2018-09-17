package com.qf.metting.utils;

import java.io.IOException;
import java.util.Properties;

public class BeanContainerUtils {
	private static Properties properties = null;
	static {
		properties = new Properties();
		try {
			properties.load(BeanContainerUtils.class.getClassLoader().getResourceAsStream("config/bean.properties"));
		} catch (IOException e) {
			System.out.println("加载文件出现问题");
		}
	}
	private static String getVal(String key) {
		return properties.getProperty(key);
	}
	public static Object getBean(String key) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String val = getVal(key);
		return Class.forName(val).newInstance();
	}
}
