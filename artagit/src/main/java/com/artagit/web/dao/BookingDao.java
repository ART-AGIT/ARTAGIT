package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Booking;

@Mapper
public interface BookingDao {

	public List<Booking> getListById(int memId) ;

}
