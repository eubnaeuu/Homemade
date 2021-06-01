package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public interface NoticeDAO {
	
	List<NoticeVO> selectNoticeList(SqlSession session, SearchCriteria cri) throws SQLException;
	
	int selectNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException;
}
