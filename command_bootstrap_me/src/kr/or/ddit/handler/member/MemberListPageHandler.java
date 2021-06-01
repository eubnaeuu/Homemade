package kr.or.ddit.handler.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.command.Criteria;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberListPageHandler implements Handler {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = "member/list1";
		System.out.println("MemberListPage Handler doget입장");
		
		String pageParam = request.getParameter("page");
		String perpageNumParam = request.getParameter("perPageNum");
		
		Criteria cri = new Criteria();
		cri.setPage(pageParam);
		cri.setPerPageNum(perpageNumParam);
		
		List<MemberVO> memberList = memberService.getMemberList(cri);
		
		request.setAttribute("memberList", memberList);
		
		return url;
	}


	
}
