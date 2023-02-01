package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;

public interface BookingService {

	//bookingId 로 paynum 가져오기
	String getPayNum (int bookingId);

	//id로 booking 가져오기
	Booking get(int id);
	
	//예매내역 가져오기
	List<BookingList> getListById(int memId,int page);

	//예매내역 가져오기(+필터링)
	List<BookingList> getListBySearch(int memId, int page, int category);
	
	
	BookingList getReviewByBookingId(int id);
	
	// 예매내역 insert 메서드
	int add(Booking booking);
	
	// payment 데이터 insert 하기 전, bookId를 얻어올 용도 (payNum을 가지고 bookId를 select)
	int getBookIdBypayNum(String payNum);
	
	//bookingId 로 exhId 가져오기
	int getExhId(int bookId);

	//BookingList : 리뷰폼에 필요한 정보들
	BookingList getBookingViewByReviewId(int id);

	BookingList getBookingViewByBookingId(int bookingId);

	//회원의 예매 내역 건수 가져오기
	int getCount(int id);

	

	
}


