package kr.or.ddit.notice.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.notice.vo.NoticeVO;

@WebServlet("/select2")
public class SelectServlet2 extends HttpServlet {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/notice/listNotice.jsp";
	
	private NoticeService noticeService = NoticeServiceImpl.getInstance();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("selectServlet doget입장");
		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		String nNo = request.getParameter("nNo");
		
//		NoticeVO noticeVo = new NoticeVO();
		
//		noticeVo.setContent(content);
//		noticeVo.setTitle(title);
//		noticeVo.setNNo(nNo);
		
		// ☆ title, content 모두 null이면 noticeVo도 null이 되는지?
		
		try {
//			List<NoticeVO> list = noticeService.selectNotice(noticeVo);
			List<NoticeVO> list = noticeService.selectAllNotice();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatehcer = request.getRequestDispatcher(VIEW_PAGE);
        requestDispatehcer.forward(request, response);
	}
	
}
