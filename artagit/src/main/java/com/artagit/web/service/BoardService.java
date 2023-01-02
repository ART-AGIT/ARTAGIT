package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;

public interface BoardService {

	List<BoardListView> getList(int page);

	Board get(int id);

	int reg(Board board);

	List<BoardListView> getListByCategory(int roleId);

	

}
