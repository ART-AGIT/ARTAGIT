package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.artagit.web.dao.BookingDao;
import com.artagit.web.dao.BookingListDao;
import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
@Service
public class DefaultBookingService implements BookingService {

	@Autowired
	private BookingListDao bookListDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public List<BookingList> getListById(int memId,int page) {
//		System.out.println("pppage"+page);

		int size = 6;
		int offset = (page-1)*size;
		return bookListDao.getListById(memId,page,offset,size);
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

	// payment 데이터 insert 하기 전, bookId를 얻어올 용도 (payNum을 가지고 bookId를 select)
	@Override
	public int getBookIdBypayNum(String payNum) {
		// TODO Auto-generated method stub
		return bookingDao.getBookIdBypayNum(payNum);
	}
	
	//bookingId(=payId) 로 exhId 가져오기
	@Override
	public int getExhId(int bookId) {
		int exhId = bookingDao.getExhId(bookId);
		return exhId;
	}

	 
	@Override
	public Booking get(int id) {
		Booking booking = bookingDao.get(id);
		return booking;
	}

	@Override
	public BookingList getBookingViewByReviewId(int id) {
		// TODO Auto-generated method stub
		return bookListDao.getByReviewId(id);
	}

	@Override
	public BookingList getBookingViewByBookingId(int bookingId) {
		// TODO Auto-generated method stub
		return bookListDao.getByBookingId(bookingId);
	}

	//예매내역 건수 가져오기
	@Override
	public int getCount(int id) {
		// TODO Auto-generated method stub
		return bookListDao.getCount(id);
	}

	@Override
	public List<BookingList> getListBySearch(int memId, int page, int category) {
		System.out.println("구현체에서 ");
		int size = 6;
		int offset = (page-1)*size;
		List<BookingList> list = bookListDao.getListBySearch(memId,offset,size,category);
		System.out.println("구현체에서 list"+list);
		return list;
	}

	@Override
	public String getPayNum(int bookingId) {
		// TODO Auto-generated method stub
		return bookingDao.getPayNum(bookingId);
	}

}


