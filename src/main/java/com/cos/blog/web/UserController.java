package com.cos.blog.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8000/blog/user
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. null과 공백 접근 금지 (유효성 검사)
		if(request.getParameter("cmd") == null || request.getParameter("cmd").equals("")) {
			return;
		}
		
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("joinForm")) {
			
		}else if(cmd.equals("join")) {
			
		}else if(cmd.equals("loginForm")) {
			
		}else if(cmd.equals("login")) {
			
		}else if(cmd.equals("updateForm")) {
			
		}else if(cmd.equals("update")) {
			
		}else if(cmd.equals("logout")) {
			
		}
	}
}


