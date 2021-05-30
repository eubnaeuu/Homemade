package kr.or.ddit.main.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
       
    public MainServlet() {
        super();
    }
    
    private static final String VIEW_PAGE = "/WEB-INF/view/main/main.jsp";

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mainservlet doget입장");
		
		RequestDispatcher requestDispatehcer = request.getRequestDispatcher(VIEW_PAGE);
        requestDispatehcer.forward(request, response);
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
