package com.cos.blog.service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.board.Board;
import com.cos.blog.domain.board.BoardDAO;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;

public class DeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통 로직 시작
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");
		
		if(principal == null) {
			Script.href("로그인을 먼저 진행해주세요", response);
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.deleteById(id);
		
		if(result == 1) {
			response.sendRedirect("/blog");
		}else {
			Script.back("글삭제 실패", response);
		}
	}
}
