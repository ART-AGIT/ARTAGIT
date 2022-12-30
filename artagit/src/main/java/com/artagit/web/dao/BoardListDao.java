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
			int page);
}
