package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.ReviewDao;
import com.artagit.web.entity.Review;

@Service
public class DefaultReviewService implements ReviewService{

	@Autowired
	ReviewDao reviewDao;
	
	@Override
	public Review get(int id) {
		// TODO Auto-generated method stub
		return reviewDao.get(id);
	}

}
