package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.domain.CrudDAO;
import com.cos.blog.web.dto.BoardDetailDTO;

public class BoardDAO implements CrudDAO<Board> {

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		return instance;
	}

	// 상세보기시 Board정보와 User정보를 조인해서 가져올 함수
	public BoardDetailDTO mDetail(int id) {
		// Board : id, title, content, created, userId
		// User : username
		BoardDetailDTO boardDetailDTO = new BoardDetailDTO();
		String sql = "SELECT b.id, b.title, b.content, u.username, u.id, b.created FROM boards b INNER JOIN users u ON b.userId= u.id WHERE b.id = ?";

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				boardDetailDTO.setId(rs.getInt(1));
				boardDetailDTO.setTitle(rs.getString(2));
				boardDetailDTO.setContent(rs.getString(3));
				boardDetailDTO.setUsername(rs.getString(4));
				boardDetailDTO.setUserId(rs.getInt(5));
				boardDetailDTO.setCreated(rs.getTimestamp(6));
			}
//			System.out.println("========================");
//			System.out.println(boardDetailDTO);
//			System.out.println("========================");
			return boardDetailDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Board findById(int id) {
		return null;
	}
	
	public List<Board> findAll(int page) {
		List<Board> boards = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("select * from ");
		sb.append("(");
		sb.append("select id, title, content, userId, created, rownum as num from boards order by id desc");
		sb.append(")");
		sb.append("where num > ? and num <= ?");

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, page*3);
			pstmt.setInt(2, (page+1)*3);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUserId(rs.getInt("userId"));
				board.setCreated(rs.getTimestamp("created"));

				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Board> findAll() {
		List<Board> boards = new ArrayList<>();
		String sql = "SELECT * FROM boards ORDER BY id DESC"; // 5, 4, 3, 2, 1

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUserId(rs.getInt("userId"));
				board.setCreated(rs.getTimestamp("created"));

				boards.add(board);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String sql = "DELETE FROM boards WHERE id = ?";

		try {
			Connection conn = DBConn.디비연결();
			// 1. PreparedStatement는 ?로 변수 바인딩이 가능
			// 2. PreparedStatement는 인젝션 공격을 방어해준다.
			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼
			pstmt.setInt(1, id);

			return pstmt.executeUpdate(); // 변경된 행의 개수
			// pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
