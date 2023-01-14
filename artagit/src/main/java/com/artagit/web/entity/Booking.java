package com.artagit.web.entity;

import java.util.Date;

public class Booking {

	private int id;
	private Date date;
	private int amount;
	private String phone;
	private String email;
	private int memId;
	private int exhId;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int id, Date date, int amount, int memId, int exhId, String phone, String email) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.memId = memId;
		this.exhId = exhId;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "Booking [id=" + id + ", date=" + date + ", amount=" + amount + ", phone=" + phone + ", email=" + email
				+ ", memId=" + memId + ", exhId=" + exhId + "]";
	}
}
