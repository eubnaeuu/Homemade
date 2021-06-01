package kr.or.ddit.handler.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.handler.Handler;
import kr.or.ddit.service.MemberService;

public class MemberListHandler implements Handler {
	
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = "member/list1";
		
		System.out.println("selectHandler doget입장");
		
//		try {
//			List<MemberVO> list = memberService.selectAllMember();
//			request.setAttribute("list", list);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			url = null;
//		}
		
		// 위처럼 try-catch문을 통해서 exception잡아줄 필요없음. 어짜피 frontservlet에서 500에러 띄움
		List<MemberVO> memberList = memberService.getMemberList();
		request.setAttribute("memberList", memberList);
		
		
		return url;
	}
	
}
