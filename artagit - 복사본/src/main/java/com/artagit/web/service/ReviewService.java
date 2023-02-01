package com.artagit.web.service;

import com.artagit.web.entity.Review;

public interface ReviewService {

	Review get(int id);

	Review reg(Review review);

	int del(int id);

	Review getbyId(int id);

	int update(Review review);
}
