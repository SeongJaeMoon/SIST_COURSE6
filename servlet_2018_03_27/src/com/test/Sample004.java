package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample004 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

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
		
		out.println("<form action=\"sample004\" method=\"post\">");
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"name\">이름:</label>");
		out.println("<input type=\"text\"	class=\"form-control\" id=\"name\" name=\"name\">");
		out.println("</div>");
		out.println("<div class=\"form-group\">");
		out.println("<label for=\"phone\">전화번호:</label> ");
		out.println("<input type=\"text\"	class=\"form-control\" id=\"phone\" name=\"phone\">");
		out.println("</div>");
		out.println("<button type=\"submit\" class=\"btn btn-default\">Submit</button>");
		out.println("</form>");

		out.println("");
		out.println("</body>");
		out.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

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
		out.println("<p>데이터 수신 결과-"+name+", "+phone+"<p>");
		out.println("");
		out.println("</body>");
		out.println("</html>");
		
	}

}
