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
	
	
	int insert(Payment payment);//o
//	int update(Payment payment);//o
	int delete(int id);
	int deleteAll(List<Payment> list);
	
}
