package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.PayList;
import com.artagit.web.entity.Payment;

public interface PaymentService {

	List<PayList> getPayListById(int id);

	//int findByBookingId(Booking bookId);

	Payment findByBookingId(int bookId);

}
