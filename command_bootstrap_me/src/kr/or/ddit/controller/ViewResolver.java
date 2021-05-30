package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	public static void view(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException{
		if (url == null) {
			return;
		}
		// 앞에 "redirect:" 붙으면 문구 삭제하고 redirect 실행 
		if(url.indexOf("redirect:") > -1 ) {
			
			String contextPath=request.getContextPath();
			
			url = contextPath +"/"+ url.replace("redirect:", "");
			 
			response.sendRedirect(url);
			
		// 그렇지 않으면  forward 실행(파일명만 넣어서 실행할 수있게끔해서)
		} else {
			String prefix = "/WEB-INF/views/";
			String subfix = ".jsp";
			url = prefix + url + subfix;
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
