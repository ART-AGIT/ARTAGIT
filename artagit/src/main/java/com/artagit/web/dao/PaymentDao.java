package com.artagit.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Payment;

@Mapper
public interface PaymentDao {

	List<Payment> getList(
			int page,
			Date startDate,
			Date endDate,
			String field,
			String input);//***
	
	Payment get(int id);
	int count(String query);//***
	
	// 결제 정보 insert 메서드	
	int add(Payment payment);

	//	int update(Payment payment);//o
	int delete(int id);
	int deleteAll(List<Payment> list);

	//int findByBookingId(int bookId);
	Payment findByBookingId(int bookId);
	
}
