package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1단계. 명령어와 관련된 비즈니스 로직 처리 -> 결과
		String msg = "Hello, Test World!";
		
		//2단계. 결과 저장 -> 뷰에 전송하기 위한 준비
		request.setAttribute("msg", msg);
		
		//3단계. 포워딩할 뷰 정보 제공
		return "WEB-INF/views/view.jsp";
	}

}
