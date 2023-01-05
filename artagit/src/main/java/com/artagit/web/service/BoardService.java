package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;

public interface BoardService {


	List<BoardListView> getList(int roleId);


	Board get(int id);

	int reg(Board board);


	void hitCountUp(Board board);

	List<BoardListView> getListInit(int page);

	int delete(int id);

	int update(Board board);


}
