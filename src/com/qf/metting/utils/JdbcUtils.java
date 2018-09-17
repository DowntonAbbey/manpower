package com.qf.metting.utils;


import java.beans.PropertyVetoException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource dataSource = null;
	static {
		dataSource=new ComboPooledDataSource();
		dataSource.setJdbcUrl("jdbc:mysql:///day1804_manpower");
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setUser("root");
			dataSource.setPassword("root");
		} catch (PropertyVetoException e) {
		}
	}
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(dataSource);
	}
}
