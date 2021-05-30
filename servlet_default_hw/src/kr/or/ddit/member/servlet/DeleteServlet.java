package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.servlet.exception.InvalidAcessException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String script="";
		try {
			throw new InvalidAcessException();
		} catch (InvalidAcessException e) {
			script="alert('"+e.getMessage()+"');"+"location.href='/servlet_default/select';";
			request.setAttribute("script",script);
			request.getRequestDispatcher("/WEB-INF/view/comm/alert.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete servlet post 입장");
		
		// 입력
		String id = request.getParameter("id");
		
		// 처리
		
		String script="";
		try {
			memberService.deleteMember(id);
			script="alert('삭제가 완료되었습니다');"+"location.href='/servlet_default/select';";
			
		} catch (SQLException e) {
			script="alert('삭제를 실패하였습니다. 관리자에게 문의하세요');"+"location.href='/servlet_default/view?id="+id+"';";
			e.printStackTrace();
		}
		
		request.setAttribute("script",script);
		request.getRequestDispatcher("/WEB-INF/view/comm/alert.jsp").forward(request, response);
		
		// 출력
	}
}
