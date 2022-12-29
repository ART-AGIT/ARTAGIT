package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Board;

@Mapper
public interface BoardDao {
	
	List<Board> getList(
			int offset,
			int size,
			Integer categoryId);
	
	Board get(int id);
	
	int count(String input);
	
	int insert(Board board);
	int update(Board board);
	int delete(int id);
	void hitCountUp(Board board);

}
