package com.cos.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;
import com.cos.blog.service.board.DeleteAction;
import com.cos.blog.service.board.DetailAction;
import com.cos.blog.service.board.ListAction;
import com.cos.blog.service.board.SaveAction;
import com.cos.blog.service.board.SaveFormAction;

// http://localhost:8000/blog/board
@WebServlet("/board")
public class BoardController extends HttpServlet {
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
		Action action = router(cmd);
		if(action != null) {
			action.execute(request, response);
		}
	}
	
	private static Action router(String cmd) {
		// http://localhost:8080/blog/board?cmd=list
		// http://localhost:8080/blog => index.jsp
		if(cmd.equals("list")) {
			return new ListAction();
		}else if(cmd.equals("detail")) {
			return new DetailAction();
		}else if(cmd.equals("delete")) {
			return new DeleteAction();
		}else if(cmd.equals("updateForm")) {
			
		}else if(cmd.equals("update")) {
			
		}else if(cmd.equals("saveForm")) {
			return new SaveFormAction();
			//  글쓰기 화면 액션 가기 (세션 검증 후)
		}else if(cmd.equals("save")) {
			// 액션만들어서 SaveAction => title, content 받아서 DB에 save하기
			return new SaveAction();
		}else if(cmd.equals("search")) {
			
		}
		return null;
	}
}
