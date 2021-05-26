package com.cos.blog.service.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.domain.board.BoardDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;
import com.cos.blog.web.dto.BoardDetailDTO;

public class DetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDetailDTO boardDetailDTO = boardDAO.mDetail(id);

		if(boardDetailDTO != null) {
			request.setAttribute("dto", boardDetailDTO);
			RequestDispatcher dis = request.getRequestDispatcher("views/board/detail.jsp");
			dis.forward(request, response);
		}else {
			Script.back("잘못된 접근입니다.", response);
		}
		

		
		//HttpSession session = request.getSession();
		//session.setAttribute("boards", boardsEntity);
		//response.sendRedirect("views/board/list.jsp");
		
	}
}
