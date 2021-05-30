package kr.or.ddit.notice.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.notice.vo.NoticeVO;

public interface NoticeService {

	List<NoticeVO> selectAllNotice() throws SQLException;
	
	List<NoticeVO> selectNotice(NoticeVO noticeVo) throws SQLException;
	
	NoticeVO viewNotice(String nNo) throws SQLException;
	
	int insertNotice(NoticeVO noticeVo) throws SQLException;

	int deleteNotice(String nNo) throws SQLException;

	int updateNotice(NoticeVO noticeVo) throws SQLException;

}
