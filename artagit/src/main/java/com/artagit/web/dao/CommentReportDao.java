package com.artagit.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.CommentReport;

@Mapper
public interface CommentReportDao {
	
	List<CommentReport> getList(
			int page,
			Date startDate,
			Date endDate,
			String field,
			String input);
	
	CommentReport get(int id);
	int count(String query); // 집계 count
	
	
	int insert(CommentReport report); 
	int update(CommentReport report);
	int delete(int id); 
	int deleteAll(CommentReport report);
}
