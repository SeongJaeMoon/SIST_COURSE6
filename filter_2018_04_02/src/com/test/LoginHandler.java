package com.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandler {

	///login/loginForm
	public String loginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		return "/WEB-INF/views/loginForm.jsp";
	}
	
	///login/login
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//�α��� �׼� ����
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//�����ͺ��̽� �׼�
		if (id.equals("admin") && pw.equals("1234")) {
			//���� ����
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", id);
		}
		
		return String.format("redirect:%s/member/list", request.getContextPath());
	}

	
}
