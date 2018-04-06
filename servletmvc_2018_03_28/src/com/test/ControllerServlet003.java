package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet003 extends HttpServlet {

	//1�ܰ�. ����� ��û ����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����� ���� �޼ҵ�
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����� ���� �޼ҵ�
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//2�ܰ�. ��û �м�
		//->Ŀ�ǵ� ���� ��� �ּ� �м�
		//->http://211.63.89.68:8090/servletmvc_20180328/test003?cmd=test
		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "hello";
		}
		
		//3�ܰ�. ���� ����Ͽ� ��û�� ��� ���� -> ���
		String msg = "";
		if (cmd.equals("test")) {
			msg = "Hello, Test World!";
		} else if (cmd.equals("sample")) {
			msg = "Hello, Sample World!";
		} else if (cmd.equals("hello")) {
			msg = "Hello, World!";
		}
		
		
		//4�ܰ�. ��� ���� -> �信 �����ϱ� ���� �غ�
		request.setAttribute("msg", msg);
		
		//5�ܰ�. ��(*.jsp)�� ������ -> RequestDispatcher 
		RequestDispatcher dispatcher = request.getRequestDispatcher("view003.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
}
