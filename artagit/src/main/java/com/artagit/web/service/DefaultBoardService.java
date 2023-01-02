package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.BoardDao;
import com.artagit.web.dao.BoardListDao;
import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;

@Service
public class DefaultBoardService implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardListDao boardListDao;

	@Override
	public List<BoardListView> getList(int page) {
		int size = 1;
		int offset = (page-1)*size;
		
		return boardListDao.getListInit(offset,size,1);
	}

	@Override
	public Board get(int id) {
		// TODO Auto-generated method stub
		return boardDao.get(id);
	}

	@Override
	public int reg(Board board) {
		// TODO Auto-generated method stub
		return boardDao.insert(board);
	}

	@Override
	public List<BoardListView> getListByCategory(int roleId) {
		// TODO Auto-generated method stub
		int page = 1;
		int size = 1;
		int offset = (page-1)*size;
		return boardListDao.getList(offset,size,roleId);
	}

	
	
	
	

	
	
}
