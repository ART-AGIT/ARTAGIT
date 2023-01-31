package com.artagit.web.service;

import com.artagit.web.entity.Museum;

// 직접적인 서비스 모음
public interface MuseumService {
	
	Museum getMuseumById(int id);
	
	// [주최자] 나의 등록전시 수정 -> 전시관 정보 수정
	int update(int id);
}
