package kr.or.ddit.member.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.servlet.exception.isEmptyIdException;
import kr.or.ddit.servlet.exception.isEmptyPwdException;

@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

	private static final String VIEW_PAGE = "/WEB-INF/view/member/insertMember2.jsp";

	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatehcer = request.getRequestDispatcher(VIEW_PAGE);
		requestDispatehcer.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if ("chkId".equals(request.getParameter("flag"))) {
			Gson gson = new Gson();

			String id = request.getParameter("id");
			try {
				MemberVO mv = memberService.viewMember(id);
				String strJson = gson.toJson(mv);
				System.out.println(strJson);
				request.setAttribute("strJson", strJson);
				if (mv != null) {
					System.out.println("mv!=null");
				} else {
					System.out.println("mv==null");
				}
				request.getRequestDispatcher("/WEB-INF/view/comm/gson.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			
			MemberVO menberVo = new MemberVO();
			
			
			try {
				BeanUtils.populate(menberVo, request.getParameterMap());
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			String script="";
			// 처리
				try {
					memberService.registerMember(menberVo);
					System.out.println("servlet의 service 이후");
					script="alert('회원가입이 완료되었습니다');"+"location.href='/servlet_default/main';";
				} catch (isEmptyIdException e) {
					script="alert('"+e.getMessage()+"');"+"location.href='/servlet_default/insert';";
				} catch (isEmptyPwdException e) {
					script="alert('"+e.getMessage()+"');"+"location.href='/servlet_default/insert';";
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("script",script);
				request.getRequestDispatcher("/WEB-INF/view/comm/alert.jsp").forward(request, response);
		}
	}
}
