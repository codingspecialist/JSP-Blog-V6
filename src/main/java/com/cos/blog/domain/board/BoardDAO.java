package com.cos.blog.domain.board;

import java.util.List;

import com.cos.blog.domain.CrudDAO;
import com.cos.blog.web.dto.BoardDetailDTO;


public class BoardDAO implements CrudDAO<Board>{

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
		// TODO Auto-generated method stub
		return 0;
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



