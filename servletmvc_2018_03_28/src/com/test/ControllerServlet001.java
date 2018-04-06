package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet001 extends HttpServlet {

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
		
		//2�ܰ�. ��û �м� -> �ּ� �м�
		
		//3�ܰ�. ���� ����Ͽ� ��û�� ��� ���� -> ���
		
		//4�ܰ�. ��� ���� -> �信 �����ϱ� ���� �غ�
		
		//5�ܰ�. ��(*.jsp)�� ������ -> RequestDispatcher 
		RequestDispatcher dispatcher = request.getRequestDispatcher("view001.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
}
