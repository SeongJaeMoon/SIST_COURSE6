package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet004 extends HttpServlet {

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
		//->http://211.63.89.68:8090/servletmvc_20180328/test004?cmd=test
		String cmd = request.getParameter("cmd");
		if (cmd == null) {
			cmd = "hello";
		}
		
		//3�ܰ�. ���� ����Ͽ� ��û�� ��� ���� -> ���
		CommandHandler handler = null;
		if (cmd.equals("test")) {
			handler = new TestHandler();
		} else if (cmd.equals("sample")) {
			handler = new SampleHandler();
		} else if (cmd.equals("hello")) {
			handler = new HelloHandler();
		}
		
		String viewPage = handler.process(request, response);
		
		//5�ܰ�. ��(*.jsp)�� ������ -> RequestDispatcher 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}
	
	
}
