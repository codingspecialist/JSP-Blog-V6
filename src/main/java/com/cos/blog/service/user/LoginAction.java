package com.cos.blog.service.user;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;
import com.cos.blog.util.ValidationHandler;

public class LoginAction implements Action{

	private static final String TAG = "LoginAction :";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		
		System.out.println(TAG+"rememberMe : "+rememberMe);
				

		
		UserDAO userDAO = UserDAO.getInstance();
		// entity는 데이터베이스와 동기화된 User 오브젝트
		User userEntity = userDAO.findByUsernameAndPassword(username, password);

		if(userEntity != null) {
			// 체크가 되었고, 로그인이 완료되었고 => response의 header에 Cookie를 저장해서 날리세요.
			// 브라우저는 rememberMe = ssar 을 가지고 있으면 된다.
			
			if(rememberMe != null) {
				Cookie cookie = new Cookie("rememberMe", userEntity.getUsername());
				response.addCookie(cookie);
			}
			
			
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
