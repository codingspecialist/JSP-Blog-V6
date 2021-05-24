package com.cos.blog.service.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;
import com.cos.blog.util.ValidationHandler;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ValidationHandler vh = new ValidationHandler();
		List<String> keys = Arrays.asList("username", "password");
		if(vh.validation(keys, request, response) != 1) {
			return;
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO userDAO = new UserDAO();
		// entity는 데이터베이스와 동기화된 User 오브젝트
		User userEntity = userDAO.findByUsernameAndPassword(username, password);

		if(userEntity != null) {
			HttpSession session = request.getSession();
			// ${principal}
			session.setAttribute("principal", userEntity);
			// session.invalidate(); // 로그아웃 코드
			response.sendRedirect("/blog");
		}else {
			Script.back("로그인 실패", response);
		}
		
		
	}
	
}
