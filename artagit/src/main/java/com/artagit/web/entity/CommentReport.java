package com.artagit.web.entity;

public class CommentReport {
	private int id;
	private int roleId;
	private int commentId;
	
	private String regDate;
	private String content;
	private String file;
	private String processDate;
	
	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public CommentReport() {
		// TODO Auto-generated constructor stub
	}
	

	public CommentReport(int id, int roleId, int postId, String regDate, String content, String file, String processDate) {
		super();
		this.id = id;
		this.roleId = roleId;
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
		return "Report [id=" + id + ", roleId=" + roleId + ", commentId=" + commentId
				+ ", regDate=" + regDate + ", content=" + content + ", file=" + file + ", processDate=" + processDate
				+ "]";
	}

	
	
}
