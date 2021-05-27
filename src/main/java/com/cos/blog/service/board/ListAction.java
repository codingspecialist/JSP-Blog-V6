package com.cos.blog.service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.domain.board.Board;
import com.cos.blog.domain.board.BoardDAO;
import com.cos.blog.service.Action;

public class ListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<Board> boardsEntity = boardDAO.findAll(page);
		
//		System.out.println("=============================");
//		System.out.println(boardsEntity.size());
		
		request.setAttribute("boards", boardsEntity);
		RequestDispatcher dis = request.getRequestDispatcher("views/board/list.jsp");
		dis.forward(request, response);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("boards", boardsEntity);
		//response.sendRedirect("views/board/list.jsp");
		
	}
}
