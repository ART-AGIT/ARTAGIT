package com.artagit.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Report;

@Mapper
public interface ReportDao {
	
	List<Report> getList(
			int page,
			Date startDate,
			Date endDate,
			String field,
			String input);
	
	Report get(int id);
	int count(String query); // 집계 count
	
	
	int insert(Report report); 
	int update(Report report);
	int delete(int id); 
	int deleteAll(Report report);
}
