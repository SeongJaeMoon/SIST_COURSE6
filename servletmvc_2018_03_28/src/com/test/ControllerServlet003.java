package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet003 extends HttpServlet {

	//1단계. 사용자 요청 수신
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 정의 메소드
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//사용자 정의 메소드
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//2단계. 요청 분석
		//->커맨드 패턴 기반 주소 분석
		//->http://211.63.89.68:8090/servletmvc_20180328/test003?cmd=test
		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "hello";
		}
		
		//3단계. 모델을 사용하여 요청한 기능 수행 -> 결과
		String msg = "";
		if (cmd.equals("test")) {
			msg = "Hello, Test World!";
		} else if (cmd.equals("sample")) {
			msg = "Hello, Sample World!";
		} else if (cmd.equals("hello")) {
			msg = "Hello, World!";
		}
		
		
		//4단계. 결과 저장 -> 뷰에 전송하기 위한 준비
		request.setAttribute("msg", msg);
		
		//5단계. 뷰(*.jsp)로 포워딩 -> RequestDispatcher 
		RequestDispatcher dispatcher = request.getRequestDispatcher("view003.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
}
