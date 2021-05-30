package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    private static final String VIEW_PAGE = "/WEB-INF/view/member/updateMember2.jsp";	
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		try {
			request.setAttribute("memberVo", memberService.viewMember(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher requestDispatehcer = request.getRequestDispatcher(VIEW_PAGE);
		requestDispatehcer.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("update servlet dopost 입장");
		
		MemberVO memberVo = new MemberVO();
		
		try {
			BeanUtils.populate(memberVo, request.getParameterMap());
			
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		String id = memberVo.getId();
		
		String script="";
		try {
			memberService.updateMember(memberVo);
			script="alert('수정이 완료되었습니다');"+"location.href='/servlet_default/view?id="+id+"';";
		} catch (SQLException e) {
			script="alert('"+e.getMessage()+"');"+"location.href='/servlet_default/view?id="+id+"';";
			e.printStackTrace();
		}
		request.setAttribute("script",script);
		request.getRequestDispatcher("/WEB-INF/view/comm/alert.jsp").forward(request, response);
		
//		String redirectUrl = request.getContextPath() + "/view?id="+memberVo.getMemId();
//		response.sendRedirect(redirectUrl);
	}
}
