package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;

public interface BookingService {

	//id로 booking 가져오기
	Booking get(int id);
	
	List<BookingList> getListById(int memId,int page);

	BookingList getReviewByBookingId(int id);
	
	// 예매내역 insert 메서드
	int add(Booking booking);
	
	// payment 데이터 insert 하기 전, bookId를 얻어올 용도 (payNum을 가지고 bookId를 select)
	int getBookIdBypayNum(String payNum);
	
	//bookingId 로 exhId 가져오기
//	int getExhId(int payId);

	//BookingList : 리뷰폼에 필요한 정보들
	BookingList getBookingViewByReviewId(int id);

	BookingList getBookingViewByBookingId(int bookingId);

	//회원의 예매 내역 건수 가져오기
	int getCount(int id);
}


