package com.artagit.web.entity;

public class BookingList {
	private int bookingId;
	private String exhName;
	private String museumName;
	private String bookingDate;
	private String payMethod;
	private String reviewCon;
	private int memId;
	private String exhPoster;
	private int reviewId;
	public BookingList() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	

	







	public BookingList(int bookingId, String exhName, String museumName, String bookingDate, String payMethod,
			String reviewCon, int memId, String exhPoster, int reviewId) {
		super();
		this.bookingId = bookingId;
		this.exhName = exhName;
		this.museumName = museumName;
		this.bookingDate = bookingDate;
		this.payMethod = payMethod;
		this.reviewCon = reviewCon;
		this.memId = memId;
		this.exhPoster = exhPoster;
		this.reviewId = reviewId;
	}


	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}






	public String getExhPoster() {
		return exhPoster;
	}






	public void setExhPoster(String exhPoster) {
		this.exhPoster = exhPoster;
	}






	public String getReviewCon() {
		return reviewCon;
	}

	public void setReviewCon(String reviewCon) {
		this.reviewCon = reviewCon;
	}




	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getExhName() {
		return exhName;
	}

	public void setExhName(String exhName) {
		this.exhName = exhName;
	}

	public String getMuseumName() {
		return museumName;
	}

	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}






	@Override
	public String toString() {
		return "BookingList [bookingId=" + bookingId + ", exhName=" + exhName + ", museumName=" + museumName
				+ ", bookingDate=" + bookingDate + ", payMethod=" + payMethod + ", reviewCon=" + reviewCon + ", memId="
				+ memId + ", exhPoster=" + exhPoster + "]";
	}





	
	
	
	
}
