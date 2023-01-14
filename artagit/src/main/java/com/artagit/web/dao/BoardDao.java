package com.artagit.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;

@Mapper
public interface BoardDao {
	
	


	Board get(int id);
	
	int count(String input);
	int update(Board board);
	int delete(int id);

	void hitCountUp(Board board);

	int insert(Board board);

//	int insert(int roleId, String originalFilename, String title, String content, int memId);

	Board getDetail(int id);

	int hitUp(int id);

	



	
	

}
