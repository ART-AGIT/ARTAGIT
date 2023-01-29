package com.artagit.web.service;

import java.util.List;
import java.util.Map;


import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;

public interface BoardService {


	List<BoardListView> getList(int roleId);


	Board get(int id);

	List<BoardListView> getListInit(int page, int size, int roleId);

	int delete(int id);

	int update(Board board);

//	int reg(int roleId, String originalFilename, String title, String content, int memId);


	Board getDetail(int id, int memId);

	//게시글 등록
	int reg(Board board);


	void hitCountUp(Board board);


	int edit(Board board);


	int hitUp(int id);


	List<BoardListView> getListById(int id);


	int likeUp(int boardId, int userId);


	int countOfLike(int id);


	int deleteLikeUp(int boardId, int userId);


	List<BoardListView> getLikeList(int memId);


	List<BoardListView> getListById(int id, int page);


	List<BoardListView> getSearchList(String query);




	






	


	

}