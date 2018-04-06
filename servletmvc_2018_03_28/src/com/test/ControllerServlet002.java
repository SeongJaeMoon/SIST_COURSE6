package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet002 extends HttpServlet {

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
		
		//2단계. 요청 분석 -> 주소 분석
		
		//3단계. 모델을 사용하여 요청한 기능 수행 -> 결과
		
		//4단계. 결과 저장 -> 뷰에 전송하기 위한 준비
		String msg = "Hello, MVC World!";
		request.setAttribute("msg", msg);
		
		//5단계. 뷰(*.jsp)로 포워딩 -> RequestDispatcher 
		RequestDispatcher dispatcher = request.getRequestDispatcher("view002.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
}
