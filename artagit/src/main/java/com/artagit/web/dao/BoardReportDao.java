package com.artagit.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.BoardReport;
import com.artagit.web.entity.CommentReport;

@Mapper
public interface BoardReportDao {
	
	List<CommentReport> getList(
			int page,
			Date startDate,
			Date endDate,
			String field,
			String input);
	
	CommentReport get(int id);
	int count(String query); // 집계 count
	
	
	int insert(BoardReport report); 
	int update(CommentReport report);
	int delete(int id); 
	int deleteAll(CommentReport report);
}
