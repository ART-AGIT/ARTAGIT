package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.BookingDao;
import com.artagit.web.dao.BookingListDao;
import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;
@Service
public class DefaultBookingService implements BookingService {

	@Autowired
	private BookingListDao bookListDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public List<BookingList> getListById(int memId) {
		return bookListDao.getListById(memId);
	}

	@Override
	public BookingList getReviewByBookingId(int id) {
		return bookListDao.getByBookingId(id);
	}

	// 예매내역 insert 메서드
	@Override
	public int add(Booking booking) {
		int result = bookingDao.add(booking);
		return result;
	}

}


