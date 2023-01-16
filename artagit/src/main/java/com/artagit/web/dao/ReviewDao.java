package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Review;

@Mapper
public interface ReviewDao {

	List<Review> getList(
			int page); 
	
	//payId 로 갖고오기
	Review get(int id);
	int insert(Review review);
	int update(Review review);
	//리뷰삭제 
	int delete(int id);

//	int create(Review review,int payId);
	//리뷰등록
	int create(Review review);

	Review getbyId(int id);
}
