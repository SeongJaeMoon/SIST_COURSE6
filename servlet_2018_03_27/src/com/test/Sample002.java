package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample002 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		// 액션 추가
		int sum = 0;
		for (int i=1; i<=10; ++i) {
			sum = sum + i;
		}
		

		// Set response content type
		response.setContentType("text/html; charset=UTF-8");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>SIST_쌍용교육센터</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("");
		out.println("<h1>Servlet Test</h1>");
		out.println("<p>1부터 10까지의 합은 "+sum+" 입니다.</p>");
		out.println("");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
