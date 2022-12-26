package com.artagit.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Member;
import com.artagit.web.entity.Museum;

@Mapper
public interface MuseumDao {
	List<Museum> getList(
			int offset,
			int size,
			String field,
			String query);
	
	Museum get(int id);		  // 1건 조회
	
	int count(String query);  // select 시 검색결과 집계(카운트)
	
	int insert(Member member);
	int update(Member member);
	int delete(int id);
}
