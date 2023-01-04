package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Board;

@Mapper
public interface BoardDao {
	
	
	Board get(int id);
	
	int count(String input);
	
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	

}
