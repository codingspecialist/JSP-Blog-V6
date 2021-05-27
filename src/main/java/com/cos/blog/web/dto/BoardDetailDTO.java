package com.cos.blog.web.dto;

import java.sql.Timestamp;

public class BoardDetailDTO{
	
	
	private int id;
	private String title;
	private String content;
	private int userId;
	private String username;
	private Timestamp created;
	
	public BoardDetailDTO() {
	
	}

	public BoardDetailDTO(int id, String title, String content, int userId, String username, Timestamp created) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.username = username;
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "BoardDetailDTO [id=" + id + ", title=" + title + ", content=" + content + ", userId=" + userId
				+ ", username=" + username + ", created=" + created + "]";
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
}
