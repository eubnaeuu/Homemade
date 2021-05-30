package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/member/viewMember2.jsp";
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("view Servlet doget입장");
		String id = request.getParameter("id");
		
		MemberVO memberVo = new MemberVO();
		
		try {
			memberVo = memberService.viewMember(id);
			request.setAttribute("memberVo", memberVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatehcer = request.getRequestDispatcher(VIEW_PAGE);
        requestDispatehcer.forward(request, response);
	}
	
}
