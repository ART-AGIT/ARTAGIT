package com.artagit.web.service;

import com.artagit.web.entity.Corporate;

public interface CorporateService {

	Corporate getCorpById(int id);

	
	// [주최자] 나의 등록전시 수정 -> 주최측 정보 수정
	int update(int id);
}
