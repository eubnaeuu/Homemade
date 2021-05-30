package kr.or.ddit.notice.servlet;

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

import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.vo.NoticeVO;

@WebServlet("/insert2")
public class InsertServlet2 extends HttpServlet {

	private static final String VIEW_PAGE = "/WEB-INF/view/notice/insertNotice.jsp";

	private NoticeService noticeService = NoticeServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher requestDispatehcer = request.getRequestDispatcher(VIEW_PAGE);
		requestDispatehcer.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
			NoticeVO noticeVo = new NoticeVO();
			
			try {
				BeanUtils.populate(noticeVo, request.getParameterMap());
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				e1.printStackTrace();
			} 
			
			String script="";
			// 처리
				try {
					noticeService.insertNotice(noticeVo);
					System.out.println("servlet의 service 이후");
					script="alert('공지글 등록이 완료되었습니다');"+"location.href='/servlet_default_hw/main';";
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("script",script);
				request.getRequestDispatcher("/WEB-INF/view/comm/alert.jsp").forward(request, response);
		}
}
