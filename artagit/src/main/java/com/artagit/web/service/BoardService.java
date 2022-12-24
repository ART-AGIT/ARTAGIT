package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Board;

public interface BoardService {

	List<Board> getList(int page);

	Board get(int id);

	int reg(Board board);

	

}
