package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet004 extends HttpServlet {

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
		//->http://211.63.89.68:8090/servletmvc_20180328/test004?cmd=test
		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "hello";
		}
		
		//3단계. 모델을 사용하여 요청한 기능 수행 -> 결과
		CommandHandler handler = null;
		if (cmd.equals("test")) {
			handler = new TestHandler();
		} else if (cmd.equals("sample")) {
			handler = new SampleHandler();
		} else if (cmd.equals("hello")) {
			handler = new HelloHandler();
		}
		
		String viewPage = handler.process(request, response);
		
		//5단계. 뷰(*.jsp)로 포워딩 -> RequestDispatcher 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}
	
	
}
