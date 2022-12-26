package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Exhibition;

@Mapper
public interface ExhibitionDao {

	// 등록된 전시를 모두 불러오는 메서드
	// field = 카테고리
	// input = 검색 키워드
//	List<Exhibition> getList(int page, 
//			String field,
//			String input);

	// 기본 목록 불러오는 메서드
	List<Exhibition> getList(int offset, int size, Integer museumId, Integer stateId, Integer cateId);
	
	// 1건의 전시를 불러올 때 사용되는 메서드
	Exhibition get(int id);
	
	// 집계 하는 메서드
	int count(String query);
	
	int insert(Exhibition exhibition);
	
	// 전시 수정
//	int update(Exhibition exhibition);
	int update(int id, String name);
	
	// 전시 삭제
	int delete(int id);

	//나의 등록전시 리스트
	List<Exhibition> getListByID(int id);
	
	//나의 등록전시개수
	int getCount(int memId);
	
}
 