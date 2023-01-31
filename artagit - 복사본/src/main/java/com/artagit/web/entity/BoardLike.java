package com.artagit.web.entity;

public class BoardLike {
	private int memId;
	private int postId;
	
	public BoardLike() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardLike(int memId, int postId) {
		this.memId = memId;
		this.postId = postId;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "BoardLike [memId=" + memId + ", postId=" + postId + "]";
	}
	
	
}
