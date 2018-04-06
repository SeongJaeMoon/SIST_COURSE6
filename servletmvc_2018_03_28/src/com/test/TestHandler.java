package com.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1�ܰ�. ��ɾ�� ���õ� ����Ͻ� ���� ó�� -> ���
		String msg = "Hello, Test World!";
		
		//2�ܰ�. ��� ���� -> �信 �����ϱ� ���� �غ�
		request.setAttribute("msg", msg);
		
		//3�ܰ�. �������� �� ���� ����
		return "WEB-INF/views/view.jsp";
	}

}
