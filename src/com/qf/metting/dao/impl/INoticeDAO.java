package com.qf.metting.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Notice;

public interface INoticeDAO extends IBaseDAO<Notice>{

	/**
	 * @throws SQLException 
	 * 通过标题查找公告
	 * @Title: findNoticeByTitle 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param noticeTitle
	 * @param @return    设定文件 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeByTitle(String noticeTitle) throws SQLException;
	/**
	 * @throws SQLException 
	 * 通过内容查找公告
	 * @Title: findNoticeByContent 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param noticeContent
	 * @param @return    设定文件 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeByContent(String noticeContent) throws SQLException;
	/**
	 * @throws SQLException 
	 *  通过标题和内容查找公告
	 * @Title: findNoticeByTitleAndContent 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param noticeTitle
	 * @param @param noticeContent
	 * @param @return    设定文件 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeByTitleAndContent(String noticeTitle, String noticeContent) throws SQLException;
	/**
	 * @throws SQLException 
	 *  添加公告
	 * @Title: addNotice 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void addNotice(Notice notice) throws SQLException;
	/**
	 * @throws SQLException 
	 * 修改公告
	 * @Title: updateNotice 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param noticeTitle
	 * @param @param noticeContent    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateNotice(String noticeTitle, String noticeContent, int noticeId) throws SQLException;

	

}
