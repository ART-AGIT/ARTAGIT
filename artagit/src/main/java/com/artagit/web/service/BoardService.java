package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;

public interface BoardService {


	List<BoardListView> getList(int roleId);


	Board get(int id);

	List<BoardListView> getListInit(int page);

	int delete(int id);

	int update(Board board);

	int reg(int roleId, String originalFilename, String title, String content, int memId);

	






	


	

}
