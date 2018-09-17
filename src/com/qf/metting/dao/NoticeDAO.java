package com.qf.metting.dao;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qf.metting.dao.impl.INoticeDAO;
import com.qf.metting.pojo.Notice;


public class NoticeDAO extends BaseDAO<Notice> implements INoticeDAO{

	public NoticeDAO() {
		super("t_notice");
	}

	@Override
	public List<Notice> findNoticeByTitle(String noticeTitle) throws SQLException {
		return getQueryRunner().query("select * from t_notice where noticeTitle like ?",new BeanListHandler<Notice>(Notice.class),"%"+noticeTitle+"%");
	}

	@Override
	public List<Notice> findNoticeByContent(String noticeContent) throws SQLException {
		return getQueryRunner().query("select * from t_notice where noticeContent like ?",new BeanListHandler<Notice>(Notice.class),"%"+noticeContent+"%");
	}

	@Override
	public List<Notice> findNoticeByTitleAndContent(String noticeTitle, String noticeContent) throws SQLException {
		return getQueryRunner().query("select * from t_notice where noticeTitle like ? and noticeContent like ?",new BeanListHandler<Notice>(Notice.class),"%"+noticeTitle+"%","%"+noticeContent+"%");
	}

	@Override
	public void addNotice(Notice notice) throws SQLException {
		getQueryRunner().update("insert into t_notice(noticeTitle,noticeContent,noticeUser,userId,noticeTime) values(?,?,?,?,?)",notice.getNoticeTitle(),notice.getNoticeContent(),notice.getNoticeUser(),notice.getUserId(),notice.getNoticeTime());
	}

	@Override
	public void updateNotice(String noticeTitle, String noticeContent, int noticeId) throws SQLException {
		getQueryRunner().update("update t_notice set noticeTitle = ?, noticeContent = ? where noticeId = ?",noticeTitle,noticeContent,noticeId);
	}

}
