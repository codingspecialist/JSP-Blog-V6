package com.cos.blog.domain.board;

import java.sql.Timestamp;

public class Board { // N, 1
	private int id; // Primary Key , Sequence
	private String title;
	private String content;
	private int userId;
	private Timestamp created;
	
	public Board() {
	
	}
	
	public Board(int id, String title, String content, int userId, Timestamp created) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
}
