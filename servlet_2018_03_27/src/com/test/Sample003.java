package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sample003 extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

		// �׼� �߰�
		StringBuilder sb = new StringBuilder();

		//�ߺ����� ���� ���� �������� ��� ���α׷� �ڵ� �ۼ�.
		//�ζ� ���� ������ ����(1~45) 6���� ������ �ߺ��� ���ڰ� ���� ���·� ���� �Ѵ�.
		//�ζ� ���� 6���� �� ���� ������ ��� ��쵵 �ߺ��Ǹ� �ȵȴ�.
		//6�� ���ڸ� ��½� ���ĵ� ���·� ����ؾ� �Ѵ�.
		//�迭�� �迭 ���
		
		/*
		��¿�)
		1. [1, 2, 3, 4, 5, 6]
		2. [1, 2, 3, 4, 5, 7]
		3. [13, 14, 15, 16, 17, 18]
		4. [19, 20, 21, 22, 23, 24]
		5. [25, 26, 27, 28, 29, 30]
		*/

		int size = 5;
		
		// �迭�� �迭 �غ�
		int[][] array2 = new int[size][6];
		
		// ���� �߻� �� �迭 ��� ����
		for (int b = 0; b < array2.length; ++b) {

			// ������ ä���� 1���� �迭 ��� ����
			int[] array1 = new int[6];
			for (int a = 0; a < array1.length; ++a) {
				int random = (int) (Math.random() * 45) + 1;
				array1[a] = random;

				// 1���� �迭 ����� �ߺ� �˻� ���� �߰�
				for (int k = 0; k < a; k++) {
					if (array1[k] == random) {
						--a;
						break;
					}
				}

			}

			// ������ ä���� 1���� �迭 ��� ����
			java.util.Arrays.sort(array1);

			// �迭�� �迭�� 1���� �迭 ����
			array2[b] = array1;
			
			// �迭�� �迭�� ����� ���� 1���� �迭��� ���� ������ 1���� �迭�� ���� �ߺ� �˻� ���� �߰�
			for (int k = 0; k < b; k++) {
				if (java.util.Arrays.equals(array2[k], array1)) {
					--b;
					break;
				}
			}
		}
		
		// �迭 ��� ���
		sb.append("<ol>");
		for (int c = 0; c < array2.length; ++c) {
			sb.append(String.format("<li>%s</li>", java.util.Arrays.toString(array2[c])));
		}
		sb.append("</ol>");
		

		// Set response content type
		response.setContentType("text/html; charset=UTF-8");

		// Actual logic goes here.
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>SIST_�ֿ뱳������</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("");
		out.println("<h1>�ζ� ��ȣ ����</h1>");
		out.println("<p>"+sb.toString()+"</p>");
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
