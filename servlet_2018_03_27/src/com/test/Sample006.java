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
	 * ����) ������ ���. 1�ܺ��� 9�ܱ����� ��ư �߿� �ϳ��� Ŭ���ϸ� ������ ��µǵ��� �Ѵ�. ���� ����� post ��� ����� ��.
	 * 
	 * 1 * 1 = 1<br> 1 * 2 = 2<br> 1 * 3 = 3<br> 1 * 4 = 4<br> 1 * 5 = 5<br> 1 * 6 =
	 * 6<br> 1 * 7 = 7<br> 1 * 8 = 8<br> 1 * 9 = 9<br>
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����� ���� �޼ҵ�
		process(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//����� ���� �޼ҵ�
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
		out.println("<h1>POST ��� ������</h1>");
		out.println("<div class=\"btn-group\" style=\"margin-top: 20px;\">");
		out.println("<button type=\"button\" class=\"btn btn-default\">1��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">2��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">3��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">4��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">5��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">6��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">7��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">8��</button>");
		out.println("<button type=\"button\" class=\"btn btn-default\">9��</button>");
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
