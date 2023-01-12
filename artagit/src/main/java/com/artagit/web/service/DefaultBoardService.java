package com.artagit.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.artagit.web.dao.BoardDao;
import com.artagit.web.dao.BoardLikeDao;
import com.artagit.web.dao.BoardListDao;
import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;



@Service
public class DefaultBoardService implements BoardService{
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private BoardListDao boardListDao;

	@Autowired
	private BoardLikeDao boardLikeDao;
	
	
	public Board get(int id) {
		// TODO Auto-generated method stub
		return boardDao.get(id);
	}


	@Override

	public void hitCountUp(Board board) {
		boardDao.hitCountUp(board);
	}

	public List<BoardListView> getList(int roleId) {
		int page =1;
		int size =10;
		int offset = (page-1)*size;
		List<BoardListView> list = boardListDao.getList(offset,size,roleId);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public List<BoardListView> getListInit(int page) {
		// TODO Auto-generated method stub
		 int size = 10;
		 int offset = (page-1)*size;
		return boardListDao.getListInit(offset,size,page);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return boardDao.delete(id);
	}

	@Override
	public int update(Board board) {
		// TODO Auto-generated method stub
		return boardDao.update(board);

	}


//
//	@Override
//	public int reg(int roleId, String originalFilename, String title, String content,int memId) {
//		// TODO Auto-generated method stub
//		return boardDao.insert(roleId,originalFilename,title,content,memId);
//	}
	
	@Override
	public int reg(Board board) {
		// TODO Auto-generated method stub
		return boardDao.insert(board);
	}


	@Override
	public Board getDetail(int id, int memId) {
		// TODO Auto-generated method stub
		
		return boardDao.getDetail(id,memId);
	}


	@Override
	public int edit(Board board) {
		// TODO Auto-generated method stub
		return boardDao.update(board);
	}


	@Override
	public int hitUp(int id) {
		// TODO Auto-generated method stub
		return boardDao.hitUp(id);
	}


	@Override
	public List<BoardListView> getListById(int id) {
		// TODO Auto-generated method stub
		return boardListDao.getListById(id);
	}


	@Override
	public int likeUp(int boardId, int userId) {
		// TODO Auto-generated method stub
		return boardLikeDao.add(boardId,userId);
	}


	@Override
	public int countOfLike(int id) {
		// TODO Auto-generated method stub
		return boardLikeDao.count(id);
	}


	@Override
	public int deleteLikeUp(int boardId, int userId) {
		// TODO Auto-generated method stub
		return boardLikeDao.delete(boardId,userId);
	}


	



}





	

	





	
	
	

	
	

