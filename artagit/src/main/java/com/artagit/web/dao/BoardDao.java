package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Board;

@Mapper
public interface BoardDao {
	
	
	Board get(int id);
	
	int count(String input);
	int update(Board board);
	int delete(int id);


	void insert(int memId, int roleId, String title, String content, String originalFilename);
	

}
