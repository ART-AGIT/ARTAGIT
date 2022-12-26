package com.artagit.web.service;

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
	void delete(int id);

	
	//내가 등록한 전시 리스트 
	List<Exhibition> getListById(int id);

	List<Exhibition> getListByCategory(int page, int museum, int state, int category);
}
