package com.cos.blog.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;

public class LoginFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 브라우저는 요청시마다 쿠키값을 서버에게 자동 전송한다.
		// 서버는 쿠키에 접근해서 rememberMe 값을 가져와서 변수에 저장한다.
		
		response.sendRedirect("views/user/loginForm.jsp");
	}
}
