package com.qf.metting.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.metting.dao.impl.IDownloadDAO;
import com.qf.metting.pojo.Download;

public class DownloadDAO extends BaseDAO<Download> implements IDownloadDAO{

	public DownloadDAO() {
		super("t_download");
	}

	@Override
	public void addFile(Download download) throws SQLException {
		getQueryRunner().update("insert into t_download(downloadTittle,downloadDes,downloadFile,downloadCreateTime,userId) values(?,?,?,?,?)",
				download.getDownloadTittle(),download.getDownloadDes(),download.getDownloadFile(),download.getDownloadCreateTime(),download.getUserId());
	}

	@Override
	public List<Download> findFileByName(String fileName) throws SQLException {
		return getQueryRunner().query("select * from t_download where downloadTittle like ?",new BeanListHandler<Download>(Download.class),"%"+fileName+"%");
	}

	@Override
	public void updateFile(Download download) throws SQLException {
		getQueryRunner().update("update t_download set downloadTittle=?, downloadDes=?,downloadFile=?,userId=? where downloadId=?",download.getDownloadTittle(),
				download.getDownloadDes(),download.getDownloadFile(),download.getUserId(),download.getDownloadId());
	}

}
