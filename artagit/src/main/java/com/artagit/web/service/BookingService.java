package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.BookingList;

public interface BookingService {


	List<BookingList> getListById(int memId);

	BookingList getReviewByBookingId(int id);
	
}

//   List<Booking> getListById(int memId);

	// 주최자가 등록한 전시 상세내역 - 결제 내역
//	List<Booking> getBookingById(int id);


