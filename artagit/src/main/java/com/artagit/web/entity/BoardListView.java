package com.artagit.web.entity;

import java.util.Date;

public class BoardListView {
	private int id;
	private int postId;
	private int memId;
	private int roleId;
	private String title;
	private String content;
	private String image;
	private int hit;
	private Date regDate;
	private String nickname;
	
	public BoardListView() {
		// TODO Auto-generated constructor stub
	}
	
	
	public BoardListView(int id, int postId, int memId, String title, String content, String image, int hit,
			Date regDate, String nickname,int roleId) {
		
		this.id = id;
		this.roleId = roleId;
		this.postId = postId;
		this.memId = memId;
		this.title = title;
		this.content = content;
		this.image = image;
		this.hit = hit;
		this.regDate = regDate;
		this.nickname = nickname;
	}
	public int getRoleid() {
		return roleId;
	}
	public void setRoleid(int roleId) {
		this.roleId = roleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "BoardListView [id=" + id + ", postId=" + postId + ", memId=" + memId + ", title=" + title + ", content="
				+ content + ", image=" + image + ", hit=" + hit + ", regDate=" + regDate + ", nickname=" + nickname
				+ "]";
	}

	
}
