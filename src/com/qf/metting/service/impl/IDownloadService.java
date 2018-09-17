package com.qf.metting.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Download;

public interface IDownloadService {
	/**
	 * 查找所有文档
	 * @Title: findDownloadAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<Download>    返回类型 
	 * @throws
	 */
	List<Download> findDownloadAll() throws SQLException;
	/**
	 * @throws SQLException 
	 * @throws Throwable 
	 * 通过标题查找文档
	 * @Title: findDownloadByTitle 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return List<Download>    返回类型 
	 * @throws
	 */
	List<Download> findDownloadByTitle(String fileName) throws SQLException;
	/**
	 * @throws SQLException 
	 * 通过id查找文旦
	 * @Title: findDownloadById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param downloadId
	 * @param @return    设定文件 
	 * @return Download    返回类型 
	 * @throws
	 */
	Download findDownloadById(int downloadId) throws SQLException;
	/**
	 * @throws SQLException 
	 * 修改文档
	 * @Title: updateDownload 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param download    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateDownload(Download download) throws SQLException;
	/**
	 * @throws SQLException 
	 * 删除文档
	 * @Title: deleteDownload 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param downloadId    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void deleteDownload(int downloadId) throws SQLException;
	/**
	 * @throws SQLException 
	 * 添加文档
	 * @Title: addDownload 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param download    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void addDownload(Download download) throws SQLException;

}
