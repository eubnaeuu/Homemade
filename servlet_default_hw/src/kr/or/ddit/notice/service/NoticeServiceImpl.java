package kr.or.ddit.notice.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;
import kr.or.ddit.notice.dao.NoticeDAO;
import kr.or.ddit.notice.dao.NoticeDAOImpl;
import kr.or.ddit.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService{

	private NoticeDAO noticeDao;
	
	private static NoticeService service;
	
	private NoticeServiceImpl(){
		noticeDao = NoticeDAOImpl.getInstance();
	}
	
	public static NoticeService getInstance() {	
		if(service == null) {
			service = new NoticeServiceImpl();
		}
		return service;
	}
	
	private SqlSessionFactory SqlSessionFactory = new OracleMyBatisSqlSessionFactory();; 
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.SqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insertNotice(NoticeVO noticeVo) throws SQLException{
		SqlSession session = SqlSessionFactory.openSession(false);
		
		int cnt = -1;
		
		cnt = noticeDao.insertNotice(session, noticeVo);
		session.close();
		
		return cnt;
	}

	@Override
	public int deleteNotice(String nNo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		int cnt = -1;
		cnt = noticeDao.deleteNotice(session, nNo);
		session.close();
		return cnt;
	}

	@Override
	public int updateNotice(NoticeVO noticeVo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		int cnt = -1;
		cnt = noticeDao.updateNotice(session, noticeVo);
		session.close();
		return cnt;
	}

	@Override
	public List<NoticeVO> selectAllNotice() throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		List<NoticeVO> list = null;
		list = noticeDao.selectAllNotice(session);
		session.close();
		return list;
	}

	@Override
	public List<NoticeVO> selectNotice(NoticeVO noticeVo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		List<NoticeVO> list = null;
		list = noticeDao.selectNotice(session, noticeVo);
		session.close();
		return list;
	}

	@Override
	public NoticeVO viewNotice(String nNo) throws SQLException {
		SqlSession session = SqlSessionFactory.openSession(false);
		NoticeVO notice = null;
		notice = noticeDao.selectNoticeByNno(session, nNo);
		session.close();
		
		return notice;
	}





	
}
