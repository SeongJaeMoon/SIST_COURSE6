package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample001 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	      // Set response content type
	      response.setContentType("text/html; charset=UTF-8");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<title>SIST_½Ö¿ë±³À°¼¾ÅÍ</title>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("");
	      out.println("<h1>Hello, Servlet World!</h1>");
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
