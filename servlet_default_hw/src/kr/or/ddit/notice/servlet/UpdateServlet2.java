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

@WebServlet("/update2")
public class UpdateServlet2 extends HttpServlet {

    private static final String VIEW_PAGE = "/WEB-INF/view/notice/updateNotice.jsp";	
	
	private NoticeService noticeService = NoticeServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		try {
			request.setAttribute("noticeVo", noticeService.viewNotice(no));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher requestDispatehcer = request.getRequestDispatcher(VIEW_PAGE);
		requestDispatehcer.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("update servlet dopost 입장");
		
		NoticeVO noticeVo = new NoticeVO();
		
		try {
			BeanUtils.populate(noticeVo, request.getParameterMap());
			
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		}
		
		String nno = noticeVo.getNno();
		
		String script="";
		try {
			noticeService.updateNotice(noticeVo);
			script="alert('공지글 수정이 완료되었습니다');"+"location.href='/servlet_default_hw/view?nNo="+nno+"';";
		} catch (SQLException e) {
			script="alert('"+e.getMessage()+"');"+"location.href='/servlet_default_hw/view?nNo="+nno+"';";
			e.printStackTrace();
		}
		request.setAttribute("script",script);
		request.getRequestDispatcher("/WEB-INF/view/comm/alert.jsp").forward(request, response);
		
	}
}
