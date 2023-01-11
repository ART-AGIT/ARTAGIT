package com.artagit.web.service;

import java.util.List;
import java.util.Map;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;

public interface BoardService {


	List<BoardListView> getList(int roleId);


	Board get(int id);

	List<BoardListView> getListInit(int page);

	int delete(int id);

	int update(Board board);

//	int reg(int roleId, String originalFilename, String title, String content, int memId);


	Board getDetail(int id);


	int reg(Board board);


	void hitCountUp(Board board);


	int edit(Board board);


	int hitUp(int id);




	






	


	

}