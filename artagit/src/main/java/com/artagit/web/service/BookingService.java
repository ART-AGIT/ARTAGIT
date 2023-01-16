package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;

public interface BookingService {


	List<BookingList> getListById(int memId);

	BookingList getReviewByBookingId(int id);
	
	// 예매내역 insert 메서드
	int add(Booking booking);
}


