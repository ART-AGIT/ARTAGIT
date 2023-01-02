package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Notice;

@Mapper
public interface NoticeDao {
	
	List<Notice> getList(int offset,
						int size);
	
//	List<Notice> getListById(int page);
//	List<Notice> getListById(int id);
//	String getListById(int id);
	
	int count(String title);
	
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);

}
