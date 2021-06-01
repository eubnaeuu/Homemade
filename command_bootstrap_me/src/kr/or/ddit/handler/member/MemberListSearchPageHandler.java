package kr.or.ddit.handler.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberListSearchPageHandler implements Handler{

	private MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url ="member/list1";
		
		System.out.println("MemberListSearchPage Handler doget입장");
		
		String page = request.getParameter("page");
		String perPageNum = request.getParameter("perPageNum");
		String keyword = request.getParameter("keyword");
		String searchType = request.getParameter("searchType");
		
		SearchCriteria cri = new SearchCriteria();
		
		cri.setKeyword(keyword);
		cri.setPage(page);
		cri.setPerPageNum(perPageNum);
		cri.setSearchType(searchType);
		
		Map<String, Object> dataMap = memberService.getMemberList(cri);
		
		request.setAttribute("memberList", dataMap.get("memberList"));
		request.setAttribute("pageMaker", dataMap.get("pageMaker"));
		
//		request.setAttribute("cri", cri); // 기존 param 넘겨줌 -> 상태 유지를 위한
		return url;
	}





}
