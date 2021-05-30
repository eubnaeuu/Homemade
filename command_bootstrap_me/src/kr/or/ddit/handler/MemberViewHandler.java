package kr.or.ddit.handler;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberService;

public class MemberViewHandler implements Handler {
	
	public MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = "member/viewMember";
		
		System.out.println("view Handler 입장");
		String id = request.getParameter("id");
		
		MemberVO memberVo = new MemberVO();
		
		try {
			memberVo = memberService.getMember(id);
			request.setAttribute("memberVo", memberVo);
		} catch (SQLException e) {
			e.printStackTrace();
			url = null;
		}
		
		
		
		return url;
	}
	
}
