package com.artagit.web.service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import com.artagit.web.entity.Exhibition;

// 직접적인 서비스 모음
public interface ExhibitionService {
	
	// 전시 등록 메서드
	// 반환타입 int => 몇 건? 성공or실패?
	int reg(Exhibition exhibition);

	// 모든 전시 목록 불러오는 메서드
	List<Exhibition> getList(int page, int museum, int state, int category);
	
	Exhibition getExhById(int exhId);
	

//	void update(Exhibition exhibition);
	void update(int id, String name);


	
	//내가 등록한 전시 리스트 
	List<Exhibition> getListById(int id);
	int countOfExh(int memId);

	List<Exhibition> getListByCategory(int page, int museum, int state, int category);

	//내가 등록한 전시 삭제하기
	void delete(int id);
	
	// 업체가 등록한 전시 상세페이지
//	Corporate getById(int corpId);



	int likeUp(int exhId, int memId);

	int likeDelete(int exhId, int memberId);

	int countOfLike(int exhId);

	List<Exhibition> getListBySearch(String query) throws SQLSyntaxErrorException;
}
