package com.artagit.web.entity;

public class BoardReport {
	private int id;
	private int roleId;
	private int postId;
	
	private String regDate;
	private String content;
	private String file;
	private String processDate;
	


	public BoardReport() {
		// TODO Auto-generated constructor stub
	}
	

	public BoardReport(int id, int roleId, int postId, String regDate, String content, String file, String processDate) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.postId = postId;
		this.regDate = regDate;
		this.content = content;
		this.file = file;
		this.processDate = processDate;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getProcessDate() {
		return processDate;
	}

	public void setProcessDate(String processDate) {
		this.processDate = processDate;
	}

	@Override
	public String toString() {
		return "Report [id=" + id + ", roleId=" + roleId + ", postId=" + postId + 
				 ", regDate=" + regDate + ", content=" + content + ", file=" + file + ", processDate=" + processDate
				+ "]";
	}

	
	
	
	
}
