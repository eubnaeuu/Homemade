package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.NoticeDAO;
import kr.or.ddit.dto.NoticeVO;

public class NoticeServiceImpl implements NoticeService {

	private SqlSessionFactory sqlSessionFactory;
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private NoticeDAO noticeDAO;
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}

	@Override
	public Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(noticeDAO.selectNoticeListCount(session,cri));

			Map<String, Object> dataMap = new HashMap<String, Object>();
			List<NoticeVO> noticeList = noticeDAO.selectNoticeList(session, cri);
			
			dataMap.put("noticeList", noticeList);
			dataMap.put("pageMaker", pageMaker);
			
			return dataMap;
		} finally {
			session.close();
		}
	}

	@Override
	public int getNoticeListCount(SearchCriteria cri) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession(false);
		int cnt = -1;
		try {
		cnt = noticeDAO.selectNoticeListCount(session, cri);
		return cnt;
		}finally {
			session.close();
		}
	}




}
