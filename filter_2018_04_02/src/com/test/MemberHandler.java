package com.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberHandler {

	///member/list
	public String list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		return "/WEB-INF/views/member.jsp";
	}
	

}
