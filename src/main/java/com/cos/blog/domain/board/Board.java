package com.cos.blog.domain.board;

import java.sql.Timestamp;

public class Board { // N, 1
	private Integer id; // Primary Key , Sequence
	private String title;
	private String content;
	private Integer userId;
	private Timestamp created;
	
	public Board() {
	
	}
	
	public Board(Integer id, String title, String content, Integer userId, Timestamp created) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.created = created;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
}
