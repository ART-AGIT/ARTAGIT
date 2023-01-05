package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Review;

@Mapper
public interface ReviewDao {

	List<Review> getList(
			int page); 
	
	Review get(int id);
	int insert(Review review);
	int update(Review review);
	int delete(int id);

//	int create(Review review,int payId);
	int create(Review review);
}
