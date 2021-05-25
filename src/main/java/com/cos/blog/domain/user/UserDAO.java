package com.cos.blog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.domain.CrudDAO;

public class UserDAO implements CrudDAO<User>{
	
	// 로그인 함수
	public User findByUsernameAndPassword(String username, String password) {
		User user = new User();
		String sql = "SELECT id, username, email, address, created FROM users WHERE username = ? AND password = ?";

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setCreated(rs.getTimestamp("created"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(User data) {
		// 쿼리를 망가트려서  Script.back()  함수 테스트 해보기
		String sql = "INSERT INTO users(id, username, password, email, address, created) VALUES(users_seq.nextval, ?, ?, ?, ?, sysdate)";
		
		// Timestamp now =  Timestamp.valueOf(LocalDateTime.now());
		
		try {
			Connection conn = DBConn.디비연결();
			// 1. PreparedStatement는 ?로 변수 바인딩이 가능
			// 2. PreparedStatement는 인젝션 공격을 방어해준다.
			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼
			User user = (User) data;
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());

			return pstmt.executeUpdate(); // 변경된 행의 개수
			// pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int update(User data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
