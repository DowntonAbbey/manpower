package com.qf.metting.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 	下载中心实体类
 * @ClassName: Download 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午9:31:05
 */

public class Download implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 5625657365274791391L;
	private int downloadId;  //下载中心的id

    private String downloadTittle;  //下载中心的标题

    private String downloadDes;    //下载中心的描述

    private String downloadFile;   //下载中心的文件

	private Date downloadCreateTime; //创建时间
	
	private int userId;

	public Download() {
		super();
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getDownloadId() {
		return downloadId;
	}

	public void setDownloadId(int downloadId) {
		this.downloadId = downloadId;
	}

	public String getDownloadTittle() {
		return downloadTittle;
	}

	public void setDownloadTittle(String downloadTittle) {
		this.downloadTittle = downloadTittle;
	}

	public String getDownloadDes() {
		return downloadDes;
	}

	public void setDownloadDes(String downloadDes) {
		this.downloadDes = downloadDes;
	}

	public String getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}

	public Date getDownloadCreateTime() {
		return downloadCreateTime;
	}

	public void setDownloadCreateTime(Date downloadCreateTime) {
		this.downloadCreateTime = downloadCreateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Download [downloadId=" + downloadId + ", downloadTittle=" + downloadTittle + ", downloadDes="
				+ downloadDes + ", downloadFile=" + downloadFile + ", downloadCreateTime=" + downloadCreateTime
				+ ", userId=" + userId + "]";
	}



	public Download(int downloadId, String downloadTittle, String downloadDes, String downloadFile,
			Date downloadCreateTime, int userId) {
		super();
		this.downloadId = downloadId;
		this.downloadTittle = downloadTittle;
		this.downloadDes = downloadDes;
		this.downloadFile = downloadFile;
		this.downloadCreateTime = downloadCreateTime;
		this.userId = userId;
	}

	
	
}
