package com.cos.blog.service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.user.User;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;

public class SaveFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");
		
		if(principal != null) {
			response.sendRedirect("views/board/saveForm.jsp");
		}else {
			Script.href("로그인을 먼저 진행해주세요", response);
		}
		
		
	}
}
