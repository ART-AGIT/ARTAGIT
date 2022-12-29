package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Booking;

public interface BookingService {

	List<Booking> getListById(int memId);
	
}
