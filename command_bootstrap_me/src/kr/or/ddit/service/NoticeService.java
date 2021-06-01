package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.Map;

import kr.or.ddit.command.SearchCriteria;

public interface NoticeService {

	Map<String, Object> getNoticeList(SearchCriteria cri) throws SQLException;
	
	int getNoticeListCount(SearchCriteria cri) throws SQLException;
}
