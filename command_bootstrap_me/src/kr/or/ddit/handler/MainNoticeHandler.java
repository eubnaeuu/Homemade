package kr.or.ddit.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainNoticeHandler implements Handler {
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		String	url = "common/noticeMain";
			
		return url;
	}

}
