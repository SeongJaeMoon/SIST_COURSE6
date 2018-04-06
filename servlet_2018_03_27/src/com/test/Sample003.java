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

		// 액션 추가
		StringBuilder sb = new StringBuilder();

		//중복되지 않은 난수 여러개를 얻는 프로그램 코드 작성.
		//로또 숫자 범위의 난수(1~45) 6개를 얻을때 중복된 숫자가 없는 상태로 얻어야 한다.
		//로또 숫자 6개를 한 번에 여러개 얻는 경우도 중복되면 안된다.
		//6개 숫자를 출력시 정렬된 상태로 출력해야 한다.
		//배열의 배열 사용
		
		/*
		출력예)
		1. [1, 2, 3, 4, 5, 6]
		2. [1, 2, 3, 4, 5, 7]
		3. [13, 14, 15, 16, 17, 18]
		4. [19, 20, 21, 22, 23, 24]
		5. [25, 26, 27, 28, 29, 30]
		*/

		int size = 5;
		
		// 배열의 배열 준비
		int[][] array2 = new int[size][6];
		
		// 난수 발생 및 배열 요소 생성
		for (int b = 0; b < array2.length; ++b) {

			// 난수가 채워진 1차원 배열 요소 생성
			int[] array1 = new int[6];
			for (int a = 0; a < array1.length; ++a) {
				int random = (int) (Math.random() * 45) + 1;
				array1[a] = random;

				// 1차원 배열 요소의 중복 검사 과정 추가
				for (int k = 0; k < a; k++) {
					if (array1[k] == random) {
						--a;
						break;
					}
				}

			}

			// 난수가 채워진 1차원 배열 요소 정렬
			java.util.Arrays.sort(array1);

			// 배열의 배열에 1차원 배열 저장
			array2[b] = array1;
			
			// 배열의 배열에 저장된 기존 1차원 배열들과 새로 생성된 1차원 배열에 대한 중복 검사 과정 추가
			for (int k = 0; k < b; k++) {
				if (java.util.Arrays.equals(array2[k], array1)) {
					--b;
					break;
				}
			}
		}
		
		// 배열 요소 출력
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
		out.println("<title>SIST_쌍용교육센터</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("");
		out.println("<h1>로또 번호 생성</h1>");
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
