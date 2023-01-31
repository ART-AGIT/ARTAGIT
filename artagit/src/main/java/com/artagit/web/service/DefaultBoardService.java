package com.artagit.web.service;

import java.util.HashMap;
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


//	@Override
//	public void hitCountUp(Board board) {
//		boardDao.hitCountUp(board);
//	}

	public List<BoardListView> getList(int roleId) {
		int page =1;
		int size =10;
		int offset = (page-1)*size;
		List<BoardListView> list = boardListDao.getList(offset,size,roleId);
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Map<String, Object> getListInit(int page, int size,int category) {
		// TODO Auto-generated method stub
//		메인페이지의 게시판 숫자때문에 설정해놓음
		if(size == 0) {
			size = 5;			
		}
		int startPageNum = 1;
		int lastPageNum = size;
		// 현재 페이지가 size/2보다 클 경우
		if (page > (size / 2)) {
			// 보여지는 페이지 첫번째 페이지 번호는 현재페이지 - ((마지막 페이지 번호/2) -1 )
			// ex 현재 페이지가 6이라면 첫번째 페이지번호는 2
			startPageNum = page - ((lastPageNum / 2) - 1);
			// 보여지는 마지막 페이지 번호는 현재 페이지 번호 + 현재 페이지 번호 - 1
			lastPageNum += (startPageNum - 1);
		}
		
		//게시글 총 개수 구하는 함수
		 double boardCount = boardListDao.getBoardAllCount();
		 int lastPage = (int)(Math.ceil(boardCount/size));
			if (page >= (lastPage - 4)) {
				// 마지막 페이지 번호는 lastPage
				lastPageNum = lastPage;
			}
		int offset = (page-1)*size;
	    Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("list", boardListDao.getListInit(offset,size,category));
        resultMap.put("currentPage", page);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
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


	@Override
	@Transactional
	public List<BoardListView> getLikeList(int memId) {
		// TODO Auto-generated method stub
		int page =1;
		int size =3;
		int offset = (page-1)*size;
		
		
		return boardListDao.getLikeList(memId,offset,size);
	}


	@Override
	public void hitCountUp(Board board) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<BoardListView> getListById(int memId, int page) {

		int size = 6;
		int offset = (page-1)*size;
		return boardListDao.getListById(memId,page,offset,size);
	}

//------------검색결과 동기
	@Override
	public  Map<String, Object> getSearchList(String query,int page) {
		// TODO Auto-generated method stub
		
		
		int size = 5;			
		
		int startPageNum = 1;
		int lastPageNum = size;
		// 현재 페이지가 size/2보다 클 경우
		if (page > (size / 2)) {
			// 보여지는 페이지 첫번째 페이지 번호는 현재페이지 - ((마지막 페이지 번호/2) -1 )
			// ex 현재 페이지가 6이라면 첫번째 페이지번호는 2
			startPageNum = page - ((lastPageNum / 2) - 1);
			// 보여지는 마지막 페이지 번호는 현재 페이지 번호 + 현재 페이지 번호 - 1
			lastPageNum += (startPageNum - 1);
		}
		
		//게시글 총 개수 구하는 함수
		 double boardCount = boardListDao.getBoardSearchCount(query);
		 int lastPage = (int)(Math.ceil(boardCount/size));
			if (page >= (lastPage - 4)) {
				// 마지막 페이지 번호는 lastPage
				lastPageNum = lastPage;
			}
		int offset = (page-1)*size;
	    Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("list", boardListDao.getSearchList(query,offset,size));
        resultMap.put("currentPage", page);
        resultMap.put("lastPage", lastPage);
        resultMap.put("startPageNum", startPageNum);
        resultMap.put("lastPageNum", lastPageNum);
		
		return resultMap;
	
	}
//------------------검색결과 비동기


@Override
public List<BoardListView> getListByPage(int page,String query) {
	// TODO Auto-generated method stub
	int size = 5;			
	int offset = (page-1)*size;
	System.out.println("size"+size+"offset"+offset+"query"+query);
	
	return boardListDao.getListByPage(query,offset,size);
}

	



}





	

	





	
	
	

	
	

