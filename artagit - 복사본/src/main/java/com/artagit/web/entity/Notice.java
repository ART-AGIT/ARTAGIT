package com.artagit.web.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private String image;
	private Date regDate;
	private int memId;
	private int hit;
	private int roleId;
	private String name;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

	
	public Notice(int id, String title, String content, String image, Date regDate, int memId, int hit, int roleId,
			String name) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.image = image;
		this.regDate = regDate;
		this.memId = memId;
		this.hit = hit;
		this.roleId = roleId;
		this.name = name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content + ", image=" + image + ", regDate="
				+ regDate + ", memId=" + memId + ", hit=" + hit + ", roleId=" + roleId + ", name=" + name + "]";
	}

	
	
	
	
	

}
