package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample006 extends HttpServlet {

	/*
	 * 
	 * 문제) 구구단 출력. 1단부터 9단까지의 버튼 중에 하나를 클릭하면 구구단 출력되도록 한다. 전송 방식은 post 방식 사용할 것.
	 * 
	 * 1 * 1 = 1<br> 1 * 2 = 2<br> 1 * 3 = 3<br> 1 * 4 = 4<br> 1 * 5 = 5<br> 1 * 6 =
	 * 6<br> 1 * 7 = 7<br> 1 * 8 = 8<br> 1 * 9 = 9<br>
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사용자 정의 메소드
		process(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//사용자 정의 메소드
		process(request, response);
		
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		StringBuilder sb = new StringBuilder();

		String num = request.getParameter("num");
		if (num == null) {
			num = "1";
		}

		for (int a = 1; a <= 9; ++a) {
			sb.append(String.format("%s * %s = %s<br>", num, a, (Integer.parseInt(num) * a)));
		}

		String eq = String.valueOf(Integer.parseInt(num) - 1);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>test</title>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
		out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>");
		out.println("<script>");
		out.println("$(document).ready(function() {");
		out.println("$(\"button\").on(\"click\", function() {");
		out.println("$(\"input#num\").val(($(this).index()+1));");
		out.println("$(\"form#myForm\").submit();");
		out.println("});");
		out.println("$(\"button\").eq(" + eq + ").addClass(\"active\");");
		out.println("});");
		out.println("");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		out.println("<h1>POST 방식 구구단</h1>");
		out.println("<div class=\"btn-group\" style=\"margin-top: 20px;\">");
		out.println("<button type=\"button\" class=\"btn btn-default\">1단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">2단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">3단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">4단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">5단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">6단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">7단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">8단</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">9단</button>");
		out.println("</div>");
		out.println("<div>");
		out.println("<h3>");
		out.println(sb.toString());
		out.println("</h3>");
		out.println("</div>");
		out.println("</div>");
		out.println("<form method = \"post\" id=\"myForm\">");
		out.println("<input type=\"hidden\" id=\"num\" name=\"num\" value=\"\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");			
		
	}
	

}
