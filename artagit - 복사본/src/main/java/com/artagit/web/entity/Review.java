package com.artagit.web.entity;

import java.sql.Date;

public class Review {
	private int id;
	private int payId;
	private String content;
	private String color;
	private Date regDate;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}
	
	public Review(int id, int payId, String content) {
		super();
		this.id = id;
		this.payId = payId;
		this.content = content;
//		this.color = color;
//		this.regDate = regDate;
	}
	
	public Review(int id, int payId, String content, String color, Date regDate) {
		super();
		this.id = id;
		this.payId = payId;
		this.content = content;
		this.color = color;
		this.regDate = regDate;
	}




	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
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

	@Override
	public String toString() {
		return "Review [id=" + id + ", payId=" + payId + ", content=" + content + ", color=" + color + ", regDate="
				+ regDate + "]";
	}

	
	
	
	
	
	
}
