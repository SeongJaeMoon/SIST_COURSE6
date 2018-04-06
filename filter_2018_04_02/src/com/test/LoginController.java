package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4703133450190553443L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자 요청 주소 분석
		// ->요청 URI + invoke() 메소드 기반 주소 분석
		String viewPage = "error";

		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);
		
		if (uri.contains("/login")) {
			uri = uri.substring(request.getContextPath().length());
			uri = uri.substring("/login/".length());
			
			//주소 분석 결과 -> 특정 액션 요청
			try {
				LoginHandler handler = new LoginHandler();
				Method m = LoginHandler.class.getMethod(uri, HttpServletRequest.class, HttpServletResponse.class);
				viewPage = (String)m.invoke(handler, request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}

			//요청 결과 -> 뷰 정보 -> 포워딩 또는 리다이렉트
			if (viewPage.contains("redirect:")) {
				response.sendRedirect(viewPage.substring("redirect:".length()));
			} else if (viewPage.contains(".jsp")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title></title>");
				out.println("</head>");
				out.println("<body>");
				out.println("Error:bad request!");
				out.println("</body>");
				out.println("</html>");	
			}
		}

	}

}
