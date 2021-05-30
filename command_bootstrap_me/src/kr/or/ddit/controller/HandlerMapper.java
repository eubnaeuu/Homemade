package kr.or.ddit.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import kr.or.ddit.context.ApplicationContext;
import kr.or.ddit.handler.Handler;

public class HandlerMapper {
	private Map<String, Handler> commandMap = new HashMap<String, Handler>();
	
	public HandlerMapper() throws Exception{
		System.out.println("-----[handlerMapper] 시작-----");
		String path = "kr/or/ddit/properties/handler"; // resourceBundle은 뒤에 .properties가 자동으로 붙음
		
		ResourceBundle rbHome = ResourceBundle.getBundle(path); 
		
		Set<String> actionSetHome=rbHome.keySet(); // uri set
		
		Iterator<String> it=actionSetHome.iterator();
		
		while(it.hasNext()){
			String command = it.next();
			System.out.println("command : " + command); // /index.do
			String actionClassName=rbHome.getString(command);
			System.out.println("actionClassName : "+actionClassName); // kr.or.ddit.handler.MainMenuHandler
			
			try {
			Class<?> actionClass = Class.forName(actionClassName);
			
			Handler commandAction = (Handler)actionClass.newInstance();
			
			// 의존주입(service, dao....)
			// 의존성 확인 및 조립
			Method[] methods = actionClass.getMethods();
			for (Method method : methods) {
				
//				System.out.println(method.getName());
				
				if(method.getName().contains("set")){
					String paramType=method.getParameterTypes()[0].getName();
					
					// 인자 추출
					System.out.println(method.getParameterTypes()[0]); // interface kr.or.ddit.service.MenuService
					System.out.println(method.getParameterTypes()[0].getName()); // kr.or.ddit.service.MenuService
					
					
					paramType=paramType.substring(paramType.lastIndexOf(".")+1);
//					System.out.println(paramType); // MenuService
					paramType=(paramType.charAt(0)+"").toLowerCase()+paramType.substring(1);
//					System.out.println(paramType); // menuService
					try {
						method.invoke(commandAction, ApplicationContext.getApplicationContext().get(paramType));
						System.out.println("[HandlerMapper : invoke] : "+ApplicationContext.getApplicationContext().get(paramType));
						System.out.println("kr.or.ddit.service.MenuServiceImpl@72d5d13d");
					}catch(Exception e) {
						e.printStackTrace();
						throw e;
					}
				}
			}
				commandMap.put(command, commandAction);
				System.out.println("[HandlerMapper] : "+command+":"+commandAction+"가 준비되었습니다");
			}catch(ClassNotFoundException e) {
				System.out.println("[HandlerMapper] : "+actionClassName+"이 존재X");
				throw e;
			}catch(InstantiationException e) {
				System.out.println("[HandlerMapper] : "+actionClassName+" 인스턴스 생성 불가");
				throw e;
			}catch(IllegalAccessException e) {
				e.printStackTrace();
				throw e;
			}
		}
		System.out.println("-----[handlerMapper] 종료-----");
	}
	
	public Handler getHandler(String url) {
		System.out.println("[handlerMapper] getHandler - url : "+url);
		Handler handler = commandMap.get(url);
		System.out.println("[handlerMapper] getHandler - handler : "+handler);
		return handler;
	}
}
