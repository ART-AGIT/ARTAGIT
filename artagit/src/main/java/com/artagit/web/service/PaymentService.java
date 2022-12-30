package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.PayList;

public interface PaymentService {

	List<PayList> getPayListById(int id);
}
