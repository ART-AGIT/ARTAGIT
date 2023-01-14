package com.artagit.web.entity;

public class Payment {
	
	private int id;
	private int bookId;
	private int payNum;
	private int price;
	private String method;
	private String regDate;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(int id, int bookId, int payNum, int price, String method, String regDate) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.payNum = payNum;
		this.price = price;
		this.method = method;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getPayNum() {
		return payNum;
	}

	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", bookId=" + bookId + ", payNum=" + payNum + ", price=" + price + ", method="
				+ method + ", regDate=" + regDate + "]";
	}
}
