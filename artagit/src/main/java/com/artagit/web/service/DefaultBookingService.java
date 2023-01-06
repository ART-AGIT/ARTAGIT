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
	
	@Override
	public List<BookingList> getListById(int memId) {
		// TODO Auto-generated method stub
		return bookListDao.getListById(memId);
	}

	@Override
	public BookingList getReviewByBookingId(int id) {
		// TODO Auto-generated method stub
		return bookListDao.getByBookingId(id);
	}

}


   
//   @Override
//   public List<Booking> getListById(int memId) {
//      // TODO Auto-generated method stub
//      return bookDao.getListById(memId);
//   }

	//주최자가 등록한 전시 상세내역 - 결제 내역
//	@Override
//	public List<Booking> getBookingById(int exhId) {
//		// TODO Auto-generated method stub
//		return bookDao.getListByExhId(exhId);
//	}

