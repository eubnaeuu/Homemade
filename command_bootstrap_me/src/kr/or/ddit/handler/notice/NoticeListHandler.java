package kr.or.ddit.handler.notice;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.NoticeService;

public class NoticeListHandler implements Handler {
	
	private NoticeService noticeService;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("noticelist handler 입장");
		
		String url = "notice/list";
		request.setCharacterEncoding("UTF-8");
		 
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setKeyword(request.getParameter("keyword"));
		cri.setSearchType(request.getParameter("searchType"));
		
		System.out.println(cri.getKeyword());
		System.out.println(cri.getSearchType());
		cri.setPage(request.getParameter("page"));
		cri.setPerPageNum(request.getParameter("perPageNum"));
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		
		request.setAttribute("noticeList", dataMap.get("noticeList"));
		request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		
		return url;
	}
	
}
