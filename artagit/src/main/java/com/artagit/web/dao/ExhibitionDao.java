package com.artagit.web.dao;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.ExhibitionView;

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
	ExhibitionView get(int id, int memberId);
	
	// 집계 하는 메서드
	int count(String query);
	
	// 전시 등록
	//int insert(Exhibition exhibition, Corporate corporate);
	
	
	/*********** 주최자 ************/
	//나의 등록전시 리스트
	List<Exhibition> getListByID(int id);
	
	// 내가 등록한 전시 수정
	int update(int id);
	
	// 나의 전시 삭제
	int delete(int id);

	
	//나의 등록전시개수
	int getCount(int memId);

	//int insert(int id, int memberId);

	List<ExhibitionView> getListBySearch(int offset, int size, int memberId, String query) throws SQLSyntaxErrorException;


	List<ExhibitionView> getListByMemberId(int offset, int size, Integer museumId, Integer stateId, Integer cateId, int memberId);

	Exhibition getexh(int exhId);

	int insert(Exhibition exhibition);

	
}
 