package com.qf.metting.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.pojo.Notice;

public interface INoticeService {
	/**
	 * @throws SQLException 
	 * 查找所有公告
	 * @Title: findNoticeAll 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @return    设定文件 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeAll() throws SQLException;
	/**
	 * 通过标题查找公告
	 * @Title: findNoticeByTitle 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeByTitle(Notice notice) throws SQLException;
	/**
	 * 通过内容查找公告
	 * @Title: finNoticeByContent 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> finNoticeByContent(Notice notice) throws SQLException;
	/**
	 * 通过标题和内容查找公告
	 * @Title: finNoticeByTitleAndContent 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException    设定文件 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> finNoticeByTitleAndContent(Notice notice) throws SQLException;
	/**
	 * @throws SQLException 
	 * 通过id查询公告
	 * @Title: findNoticeById 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice
	 * @param @return    设定文件 
	 * @return Notice    返回类型 
	 * @throws
	 */
	Notice findNoticeById(Notice notice) throws SQLException;
	/**
	 * @throws SQLException 
	 * 添加公告
	 * @Title: addNotice 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void addNotice(Notice notice) throws SQLException;
	/**
	 * @throws SQLException 
	 * 删除公告
	 * @Title: deleteNotice 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void deleteNotice(Notice notice) throws SQLException;
	/**
	 * @throws SQLException 
	 * 修改公告
	 * @Title: updateNotice 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param notice    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateNotice(Notice notice) throws SQLException;

}
