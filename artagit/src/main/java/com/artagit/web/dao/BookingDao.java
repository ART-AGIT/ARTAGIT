package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.Payment;

@Mapper
public interface BookingDao {

	public List<Booking> getListById(int memId) ;
	
	// 예매 정보 insert 메서드	
	int add(Booking booking);
}

