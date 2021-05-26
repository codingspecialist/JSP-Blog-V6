package com.cos.blog.service.board;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.board.Board;
import com.cos.blog.domain.board.BoardDAO;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;
import com.cos.blog.util.ValidationHandler;

public class SaveAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통 로직 시작
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");
		
		if(principal == null) {
			Script.href("로그인을 먼저 진행해주세요", response);
			return;
		}
		
//		ValidationHandler vh = new ValidationHandler();
//		List<String> keys = Arrays.asList("title", "content");
//		if(vh.validation(keys, request, response) != 1) {
//			return;
//		}
		// 공통 로직 끝
		
		// 핵심 로직
		// 글을 DB INSERT 하기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setUserId(principal.getId());
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.save(board);
		
		if(result == 1) {
			response.sendRedirect("/blog");
		}else {
			Script.back("글쓰기 실패", response);
		}
		
	}
}
