package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.BoardDao;
import com.artagit.web.entity.Board;

@Service
public class DefaultBoardService implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> getList(int page) {
		int size = 1;
		int offset = (page-1)*size;
		
		return boardDao.getList(offset,size,1);
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
	public void hitCountUp(Board board) {
		boardDao.hitCountUp(board);
		
	}

	
	
	
	

	
	
}
