package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;

@Mapper
public interface BookingListDao {

	public List<BookingList> getListById(int memId) ;

	public BookingList getByBookingId(int id);

	public BookingList getByReviewId(int id);

}


//   public List<Booking> getListById(int memId) ;

//	주최자가 등록한 전시 상세 내역 - 결제 내역
//	List<Booking> getListByExhId(int exhId);

