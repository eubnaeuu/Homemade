package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.NoticeVO;

public class NoticeDAOImpl implements NoticeDAO{
	

	@Override
	public List<NoticeVO> selectNoticeList(SqlSession session, SearchCriteria cri) throws SQLException {
		
		int offset = cri.getStartRowNum();
		int limit= cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<NoticeVO> noticeLilst = session.selectList("Notice-Mapper.selectNoticeList", cri, rowBounds);
		
		return noticeLilst;
	}

	@Override
	public int selectNoticeListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int cnt = -1;
		cnt = session.selectOne("Notice-Mapper.selectNoticeListCount", cri);
		return cnt;
	}
	
	
}
