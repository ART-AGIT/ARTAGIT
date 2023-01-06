package com.artagit.web.entity;

public class PostLike {
	
	private int memId;
	private int postId;
	
	public PostLike() {
		// TODO Auto-generated constructor stub
	}
	public PostLike(int memId, int postId) {
		super();
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
		return "PostLike [memId=" + memId + ", postId=" + postId + "]";
	}

	
	
}
