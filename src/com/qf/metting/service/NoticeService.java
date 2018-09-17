package com.qf.metting.service;

import java.sql.SQLException;
import java.util.List;

import com.qf.metting.dao.impl.INoticeDAO;
import com.qf.metting.pojo.Notice;
import com.qf.metting.service.impl.INoticeService;
import com.qf.metting.utils.BeanContainerUtils;

public class NoticeService implements INoticeService{
	
	private INoticeDAO noticeDAO;
	{
		try {
			noticeDAO = (INoticeDAO) BeanContainerUtils.getBean("INoticeDAO");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("实例化iNotice对象失败");
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Notice> findNoticeAll() throws SQLException {
		return noticeDAO.findAll();
	}
	
	@Override
	public List<Notice> findNoticeByTitle(Notice notice) throws SQLException {
		return noticeDAO.findNoticeByTitle(notice.getNoticeTitle());
	}
	
	@Override
	public List<Notice> finNoticeByContent(Notice notice) throws SQLException {
		return noticeDAO.findNoticeByContent(notice.getNoticeContent());
	}
	
	@Override
	public List<Notice> finNoticeByTitleAndContent(Notice notice) throws SQLException {
		return noticeDAO.findNoticeByTitleAndContent(notice.getNoticeTitle(),notice.getNoticeContent());
	}

	@Override
	public Notice findNoticeById(Notice notice) throws SQLException {
		return noticeDAO.findTById("t_notice", notice.getNoticeId(), "noticeId");
	}

	@Override
	public void addNotice(Notice notice) throws SQLException {
		if(!"".equals(notice.getNoticeTitle())&& !"".equals(notice.getNoticeContent())){
			noticeDAO.addNotice(notice);	
		}
	}

	@Override
	public void deleteNotice(Notice notice) throws SQLException {
		noticeDAO.deleteById(notice.getNoticeId(), "noticeId");
		
	}

	@Override
	public void updateNotice(Notice notice) throws SQLException {
		noticeDAO.updateNotice(notice.getNoticeTitle(),notice.getNoticeContent(),notice.getNoticeId());
		
	}

}
