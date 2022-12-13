package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Exhibition;

@Mapper
public interface ExhibitionDao {

	List<Exhibition> getList(int page, 
			String field,
			String query);
	
	Exhibition get(int id);
	int count(String query);
	
	int insert(Exhibition menu);
	int update(Exhibition menu);
	int delete(int id);
	
}
 