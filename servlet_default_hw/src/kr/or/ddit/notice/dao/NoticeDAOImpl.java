package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.OracleMyBatisSqlSessionFactory;
import kr.or.ddit.notice.vo.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO{
	
	private static NoticeDAO memdao;
	private static OracleMyBatisSqlSessionFactory ssf;
	private SqlSession session;
	
	public NoticeDAOImpl() {
		ssf = new OracleMyBatisSqlSessionFactory();
		session = ssf.openSession();
	}
	
	public static NoticeDAO getInstance() {
		if(memdao == null) {
			memdao = new NoticeDAOImpl();
		}
		return memdao;
	}
	
	@Override
	public NoticeVO selectNoticeByNno(SqlSession session, String nNo) throws SQLException {
		NoticeVO noticevo = null;
		noticevo = session.selectOne("notice.selectNoticeByNno",nNo);
		return noticevo;
	}
	
	@Override
	public List<NoticeVO> selectAllNotice(SqlSession session) throws SQLException {
		List<NoticeVO> list = null;
		list = session.selectList("notice.selectNoticeAll");
		return list;
	}
	
	@Override
	public List<NoticeVO> selectNotice(SqlSession session, NoticeVO noticeVo) throws SQLException {
		List<NoticeVO> list = null;
		list = session.selectList("notice.selectNotice",noticeVo);
		return list;
	}

	@Override
	public int insertNotice(SqlSession session, NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		Object obj = session.insert("notice.insertNotice",noticeVo);
		
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int deleteNotice(SqlSession session, String memId) throws SQLException {
		int cnt = 0;
		cnt = session.delete("notice.deleteNotice",memId);
		return cnt;
	}

	@Override
	public int updateNotice(SqlSession session, NoticeVO noticeVo) throws SQLException {
		int cnt = 0;
		
		cnt = session.update("notice.updateNotice",noticeVo);
		
		return cnt;
	}
	
	
}
