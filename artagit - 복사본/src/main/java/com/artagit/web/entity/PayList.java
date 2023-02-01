package com.artagit.web.entity;

import java.util.Date;

public class PayList {
	
	private int id; 
	private int exhId; 
	private String amount;
	private int bookId;
	private String method;
	private int payNum;
	private int price; 
	private Date regDate;
	
	public PayList() {
		// TODO Auto-generated constructor stub
	}

	public PayList(int id, int exhId, String amount, int bookId, String method, int payNum, int price, Date regDate) {
		
		this.id = id;
		this.exhId = exhId;
		this.amount = amount;
		this.bookId = bookId;
		this.method = method;
		this.payNum = payNum;
		this.price = price;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExhId() {
		return exhId;
	}

	public void setExhId(int exhId) {
		this.exhId = exhId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "PayList [id=" + id + ", exhId=" + exhId + ", amount=" + amount + ", bookId=" + bookId + ", method="
				+ method + ", payNum=" + payNum + ", price=" + price + ", regDate=" + regDate + "]";
	}	
	
	
	
}
