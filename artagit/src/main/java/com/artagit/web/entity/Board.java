package com.artagit.web.entity;

import java.util.Date;

public class Board {
	private int id;
	private int roleId;
	private int memId;
	private String title;
	private String content;
	private String image;
	private int hit;
	private Date regDate;
	private Date modiDate;
	

	public Board(int id, int roleId, int memId, String title, String content, String image, int hit, Date regDate,
			Date modiDate) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.memId = memId;
		this.title = title;
		this.content = content;
		this.image = image;
		this.hit = hit;
		this.regDate = regDate;
		this.modiDate = modiDate;
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
	public void setRoldId(int roleId) {
		this.roleId = roleId;
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
	public Date getModiDate() {
		return modiDate;
	}
	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", roleId=" + roleId + ", memId=" + memId + ", title=" + title + ", content="
				+ content + ", image=" + image + ", hit=" + hit + ", regDate=" + regDate + ", modiDate=" + modiDate
				+ "]";
	}

}
