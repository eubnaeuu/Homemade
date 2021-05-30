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
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.servlet.exception.InvalidPasswordException;
import kr.or.ddit.servlet.exception.NotFoundIDException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/view/member/loginMember2.jsp";
		
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("login servlet post 입장");
		MemberVO mv = new MemberVO();

		// 입력, 처리, 출력
		
		String view = "/WEB-INF/view/comm/alert.jsp";
		
		// 입력
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 처리
		String script="";
		try {
			MemberVO memberVo = memberService.login(id, pwd);
			script = "alert(\"로그인에 성공했습니다\");"+"location.href='/servlet_default/select';";
		} catch (NotFoundIDException e) {
			script="alert('"+e.getMessage()+"');"+"location.href='/servlet_default/login';"; 
		} catch (InvalidPasswordException e) {
			script="alert('"+e.getMessage()+"');"+"location.href='/servlet_default/login';"; 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 출력
		request.setAttribute("script",script);
		request.getRequestDispatcher(view).forward(request, response);
	}
}
