package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardLikeDao {

	int add(int postId, int memId);

	int count(int id);

	int delete(int postId, int memId);
	
	
	

}
