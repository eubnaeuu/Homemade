package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.handler.Handler;

public class FrontServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestPro(request,response);
	}


	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----[FrontServlet] requsetPro 시작-----");
		// 사용자 URI 검출
		String command = request.getRequestURI(); // contextPath 포함
		
		if(command.indexOf(request.getContextPath())==0){
			command = command.substring(request.getContextPath().length()); // /index.do
		}
		
		// commandHandler 실행 (HandlerMapper 의뢰 / handler 할당)
		Handler handler = null;
		String view = null;
		
		if (handlerMapper != null) {
			handler = handlerMapper.getHandler(command); // member.do
			if (handler != null) { // 올바른 요청
				try {
					view = handler.process(request, response);
					if(view!=null) ViewResolver.view(request, response, view);
					
				}catch(Exception e) {
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); 	
				}
			} else {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST); // 404
			}
		} else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500
		}
		System.out.println("-----[FrontServlet] requsetPro 종료-----");
	}

	private HandlerMapper handlerMapper;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("-----[FrontServlet] init 시작-----");
		String handlerMapperType = config.getInitParameter("handlerMapper");
		System.out.println("handlerMapperType :\t"+handlerMapperType); 
		// kr.or.ddit.controller.HandlerMapper ( web.xml에서 파싱)
		try {

			this.handlerMapper = (HandlerMapper) injectionBean(handlerMapperType);
			System.out.println("[FrontServlet] handlerMapper 가 준비 완료");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("[FrontServlet] handlerMapper 가 준비되지 않음");
		}
		
		
		
		super.init(config);
		System.out.println("-----[FrontServlet] init 종료-----");
	}
	
	// 핸들러 매퍼주소를 파라미터로 해서 핸들러 인스턴스 생성후 반환?
	private Object injectionBean(String classType) throws Exception {
		System.out.println("-----[FrontServlet] injectionBean 시작-----");
		Class<?> cls = Class.forName(classType);
		System.out.println("-----[FrontServlet] injectionBean 종료-----");
		return cls.newInstance();
	}
}
