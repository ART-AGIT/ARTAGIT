package com.artagit.web.entity;

public class ExhLike {
	
	private int id;
	private int memId;
	private int exhId;
	private String regDate;
	
	public ExhLike() {
		// TODO Auto-generated constructor stub
	}
	
	public ExhLike(int memId, int exhId) {

		this.memId = memId;
		this.exhId = exhId;
	}

	public ExhLike(int id, int memId, int exhId, String regDate) {

		this.id = id;
		this.memId = memId;
		this.exhId = exhId;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ExhLike [id=" + id + ", memId=" + memId + ", exhId=" + exhId + ", regDate=" + regDate + "]";
	}


}
