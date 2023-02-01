package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.PayList;
import com.artagit.web.entity.Payment;
import com.artagit.web.entity.Review;

public interface PaymentService {

	List<PayList> getPayListById(int id);

	//int findByBookingId(Booking bookId);

	Payment findByBookingId(int bookId);
	
	// 결제내역 insert 메서드
	int add(Payment payment);

	//결제내역 get 메소드 
	Payment get(int id);

	
}
