package kr.or.ddit.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTMLView {
	
	public static void html(HttpServletResponse response, String title, String body) throws IOException, ServletException {
		html(response, title, null, null, body);
	}
	
	public static void html(HttpServletResponse response, String script) throws IOException, ServletException {
		html(response, null, null, script, null);
	}
	
	public static void html(HttpServletResponse response, String title,String css, String script, String body) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>"+title+"</title>");
		out.println("<style>"+css+"</style>");
		out.println("<script>"+script+"</script>");
		out.println("</head>");
		out.println("<body>"+body+"</body>");
		out.println("</html>");
	}
	
	public static void loginView(HttpServletResponse response) throws IOException, ServletException {
		
		String title = "로그인화면"; 
		String body = null;
		body = ""  
				+"    <form action=\"login\" method=\"post\">"
				+"        <fieldset>"
				+"            <legend>로그인</legend>"
				+"            <label for=\"id\">아이디 <input type=\"text\" name=\"id\" id=\"id\"></label><br>"
				+"            <label for=\"pwd\">비밀번호 <input type=\"password\" name=\"pwd\" id=\"pwd\"></label><br>"
				+"            <button type=\"submit\">확인</button>"
				+"            <button type=\"reset\">취소</button>"
				+"        </fieldset>"
				+"    </form>";
		
		html(response, title, body);
		
	}
	
	
	

}
