package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Board;

@Mapper
public interface BoardDao {
	
	
	Board get(int id);
	
	int count(String input);
	int update(Board board);
	int delete(int id);
	int insert(Board board);

	int insert(int roleId, String originalFilename, String title, String content, int memId);

	
	

}
