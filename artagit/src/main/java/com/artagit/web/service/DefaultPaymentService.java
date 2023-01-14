package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.PayListDao;
import com.artagit.web.dao.PaymentDao;
import com.artagit.web.entity.PayList;
import com.artagit.web.entity.Payment;

@Service
public class DefaultPaymentService implements PaymentService {

	@Autowired
	private PaymentDao payDao;
	
	@Autowired
	private PayListDao payListDao;
	
	@Override
	public List<PayList> getPayListById(int id) {
		
		return payListDao.getList(id);
	}
/*
	@Override
	public int findByBookingId(int bookId) {
		System.out.println("서비스함수");
		return payDao.findByBookingId(bookId);
	}
*/
	@Override
	public Payment findByBookingId(int bookId) {
//		System.out.println("payment서비스에서 bookId "+bookId);
		return payDao.findByBookingId(bookId);
	}
	
	// 결제내역 insert 메서드
	@Override
	public int add(Payment payment) {
		int result = payDao.add(payment);
		return result;
	}
	
	
}
