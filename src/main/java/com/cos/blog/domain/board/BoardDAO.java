package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.domain.CrudDAO;
import com.cos.blog.web.dto.BoardDetailDTO;


public class BoardDAO implements CrudDAO<Board>{

	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// 상세보기시 Board정보와 User정보를 조인해서 가져올 함수
	public BoardDetailDTO mDetail(int id) {
		return null;
	}

	@Override
	public Board findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(Board data) {
		String sql = "INSERT INTO boards(id, title, content, userId, created) VALUES(boards_seq.nextval, ?, ?, ?, sysdate)";

		try {
			Connection conn = DBConn.디비연결();
			// 1. PreparedStatement는 ?로 변수 바인딩이 가능
			// 2. PreparedStatement는 인젝션 공격을 방어해준다.
			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼
			pstmt.setString(1, data.getTitle());
			pstmt.setString(2, data.getContent());
			pstmt.setInt(3, data.getUserId());

			return pstmt.executeUpdate(); // 변경된 행의 개수
			// pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(Board data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}



