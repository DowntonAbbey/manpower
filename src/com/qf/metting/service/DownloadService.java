package com.qf.metting.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.dao.DownloadDAO;
import com.qf.metting.dao.impl.IDownloadDAO;
import com.qf.metting.pojo.Download;
import com.qf.metting.service.impl.IDownloadService;
import com.qf.metting.utils.BeanContainerUtils;

public class DownloadService implements IDownloadService{

	private IDownloadDAO downloadDAO = null;;
	{
		try {
			downloadDAO =  (DownloadDAO) BeanContainerUtils.getBean("IDownloadDAO");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Download> findDownloadAll() throws SQLException {
		// TODO Auto-generated method stub
		return downloadDAO.findAll();
	}
	@Override
	public List<Download> findDownloadByTitle(String fileName) throws SQLException{
		
		return downloadDAO.findFileByName(fileName);
	}
	@Override
	public Download findDownloadById(int downloadId) throws SQLException {
		
		return downloadDAO.findTById("t_download", downloadId, "downloadId");
	}
	@Override
	public void updateDownload(Download download) throws SQLException {
		downloadDAO.updateFile(download);
		
	}
	@Override
	public void deleteDownload(int downloadId) throws SQLException {
		downloadDAO.deleteById(downloadId, "downloadId");
		
	}
	@Override
	public void addDownload(Download download) throws SQLException {
		downloadDAO.addFile(download);
	}

}
