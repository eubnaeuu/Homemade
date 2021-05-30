package kr.or.ddit.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/print.html")
public class PrintOutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("Hello");
//		Scanner scan = new Scanner(System.in);
		
		String message = request.getParameter("message");
		String color = request.getParameter("color");
		String bg = request.getParameter("bg");
		
		response.setContentType("text/html;charset=utf-8"); // 이건 text/html 형식이고 출력은 utf-8인코딩한거야
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>제목</title>");
		out.print("<style>");
		out.print("body { background-color : "+bg+"}");
		out.print("body { color : "+color+"}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.printf("<h2>%s</h2>",message);
		out.print("</body>");
		out.print("</html>");
		
		
//		out.printf("<h2>%s</h2>",scan.nextLine());
		
	}

}
