package com.artagit.web.entity;

import java.util.Date;

public class Comment {
	
	
	private int id;
	private int postId;
	private int memId;
	private String content;
	private Date regDate;
	private Date modiDate;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int id, int postId, int memId, String content, Date regDate, Date modiDate) {
		super();
		this.id = id;
		this.postId = postId;
		this.memId = memId;
		this.content = content;
		this.regDate = regDate;
		this.modiDate = modiDate;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public Date getModiDate() {
		return modiDate;
	}


	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}




	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", memId=" + memId + ", content=" + content + ", regDate="
				+ regDate + ", modiDate=" + modiDate + "]";
	}
	
}
