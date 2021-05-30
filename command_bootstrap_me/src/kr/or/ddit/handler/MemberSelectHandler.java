package kr.or.ddit.handler;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.service.MemberService;

public class MemberSelectHandler implements Handler {
	
	public MemberService memberService;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String url = "member/listMember";
		
		System.out.println("selectHandler doget입장");
//		String id = request.getParameter("id");
//		String phone = request.getParameter("phone");
//		SimpleDateFormat transFormat = new SimpleDateFormat("yy-MM-dd");
//		Date regDate = transFormat.parse(request.getParameter("regDate"));
//		
//		
//		MemberVO memberVo = new MemberVO();
//		memberVo.setId(id);
//		memberVo.setPhone(phone);
//		memberVo.setRegDate(regDate);
//		
		try {
			List<MemberVO> list = memberService.selectAllMember();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
			url = null;
		}
		
		
		return url;
	}
	
}
