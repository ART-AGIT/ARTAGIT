package com.artagit.web.dao;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.ExhLikeList;
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
	//List<Exhibition> getList(int offset, int size, Integer museumId, Integer stateId, Integer cateId);
	
	// 1건의 전시를 불러올 때 사용되는 메서드
	ExhibitionView get(int id, int memberId);
	
	// 집계 하는 메서드
	int count(String query);
	
	// 전시 등록
	//int insert(Exhibition exhibition, Corporate corporate);
	
	
	/*********** 주최자 ************/
	//나의 등록전시 리스트
	List<Exhibition> getListByIdInit(int id, int limit);
	
	// 내가 등록한 전시 수정
//	int update(int id);
	int update(Exhibition exh);
	
	// 나의 전시 삭제
	int delete(int id);

	
	//나의 등록전시개수
	int getCount(int memId);

	List<Exhibition> getListtt(int memId);

	int insert(int id, int memberId);

	//int insert(int id, int memberId);



	List<ExhibitionView> getListBySearch(int offset, int size, int memberId, String query) throws SQLSyntaxErrorException;


	List<ExhibitionView> getListByMemberId(int offset, int size, Integer local, Integer state, Integer category, int memberId);

	Exhibition getexh(int exhId);

	//[주최자] 전시등록
	int insert(Exhibition exhibition);
	
	//[주최자] 가장 최근에 등록한 전시
	Exhibition getLast(int corpId);

	// [일반회원] 좋아요 전시
	List<Exhibition> getLikeList(int id);
//	List<Exhibition> getLikeList(int id, int page, int offset, int size);
	
	List<Exhibition> getListById(int id,int size,int offset);

	// 좋아요 전시 더보기
	List<ExhLikeList> getLikeListById(int id, int size, int offset);
	List<Exhibition> getLikeListAll(int id);

	String getPayNum();
}
 