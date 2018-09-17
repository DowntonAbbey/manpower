package com.qf.metting.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Download;

public interface IDownloadDAO extends IBaseDAO<Download>{
	/**
	 * @throws SQLException 
	 * 添加文档
	 * @Title: addFile 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param download    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void addFile(Download download) throws SQLException;
	/**
	 * @throws SQLException 
	 * @throws Throwable 
	 * 通过名字查找文档
	 * @Title: findFileByName 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param FileName
	 * @param @return    设定文件 
	 * @return List<Download>    返回类型 
	 * @throws
	 */
	List<Download> findFileByName(String FileName) throws SQLException;
	/**
	 * @throws SQLException 
	 * 修改文档
	 * @Title: updateFile 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param download    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateFile(Download download) throws SQLException;
	
}
