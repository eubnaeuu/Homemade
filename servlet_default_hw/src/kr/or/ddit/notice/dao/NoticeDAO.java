package kr.or.ddit.notice.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.notice.vo.NoticeVO;

public interface NoticeDAO {
	
	NoticeVO selectNoticeByNno(SqlSession session, String nNo) throws SQLException;

	List<NoticeVO> selectAllNotice(SqlSession session) throws SQLException;
	
	List<NoticeVO> selectNotice(SqlSession session, NoticeVO noticeVo) throws SQLException;
	
	int insertNotice(SqlSession session, NoticeVO NoticeVO) throws SQLException;

	int deleteNotice(SqlSession session, String nNo) throws SQLException;

	int updateNotice(SqlSession session, NoticeVO NoticeVO) throws SQLException;
	
}
