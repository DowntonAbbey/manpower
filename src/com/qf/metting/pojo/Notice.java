package com.qf.metting.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *	公告实体类
 * @ClassName: Notice 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author hou
 * @date 2018年8月28日 上午9:27:52
 */
public class Notice implements Serializable{

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 */ 
	private static final long serialVersionUID = 5036712346769709574L;

	private int noticeId;   //公告id

    private String noticeTitle;  //公告的名字

    private Date noticeTime; //公告创建时间
    
    private String noticeContent;   //公告的描述 
    
    private String noticeUser;
    
    private int userId;      //公告的人是谁

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeUser() {
		return noticeUser;
	}

	public void setNoticeUser(String noticeUser) {
		this.noticeUser = noticeUser;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Notice(int noticeId, String noticeTitle, Date noticeTime, String noticeContent, String noticeUser,
			int userId) {
		super();
		this.noticeId = noticeId;
		this.noticeTitle = noticeTitle;
		this.noticeTime = noticeTime;
		this.noticeContent = noticeContent;
		this.noticeUser = noticeUser;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeTitle=" + noticeTitle + ", noticeTime=" + noticeTime
				+ ", noticeContent=" + noticeContent + ", noticeUser=" + noticeUser + ", userId=" + userId + "]";
	}

	
	

	
	

}
