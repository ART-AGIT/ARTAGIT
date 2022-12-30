package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.PayListDao;
import com.artagit.web.entity.PayList;

@Service
public class DefaultPaymentService implements PaymentService {

	@Autowired
	private PayListDao payListDao;
	
	@Override
	public List<PayList> getPayListById(int id) {
		
		return payListDao.getList(id);
	}
	
	
}
