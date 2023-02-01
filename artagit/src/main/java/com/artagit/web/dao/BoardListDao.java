package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.BoardListView;


@Mapper
public interface BoardListDao {
	List<BoardListView> getList(
			int offset,
			int size, int roleId);
	
	List<BoardListView> getListInit(
			int offset,
			int size,
			
			int roleId);

	List<BoardListView> getListById(int memId);

	List<BoardListView> getLikeList(int memId,int offset,int size);

	List<BoardListView> getListById(int memId, int page, int offset, int size);

	List<BoardListView> getSearchList(String query, int offset, int size);

	double getBoardAllCount();

	double getBoardSearchCount(String query);

	List<BoardListView> getListByPage(String query,int size,int offset);
	
}
