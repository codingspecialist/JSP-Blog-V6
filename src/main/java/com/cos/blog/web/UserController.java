package com.cos.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;
import com.cos.blog.service.user.JoinAction;
import com.cos.blog.service.user.JoinFormAction;
import com.cos.blog.service.user.LoginAction;
import com.cos.blog.service.user.LoginFormAction;
import com.cos.blog.service.user.LogoutAction;

// http://localhost:8000/blog/user
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. null과 공백 접근 금지 (유효성 검사)
		if (request.getParameter("cmd") == null || request.getParameter("cmd").equals("")) {
			return;
		}

		String cmd = request.getParameter("cmd");
		Action action = router(cmd);
		if(action != null) {
			action.execute(request, response);
		}
	}

	// router에게 객체 생성을 위임하고 결과를 응답받음. (팩토리 패턴)
	private Action router(String cmd){
		if (cmd.equals("joinForm")) {
			return new JoinFormAction();
		} else if (cmd.equals("join")) {
			return new JoinAction();
		} else if (cmd.equals("loginForm")) {
			return new LoginFormAction();
		} else if (cmd.equals("login")) {
			return new LoginAction();
		} else if (cmd.equals("updateForm")) {

		} else if (cmd.equals("update")) {

		} else if (cmd.equals("logout")) {
			return new LogoutAction();
		}
		return null;
	}
}
