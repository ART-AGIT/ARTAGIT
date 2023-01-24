package com.artagit.web.service;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;

public interface CorporateService {

	Corporate getCorpById(int id);

	
	// [주최자] 나의 등록전시 수정 -> 주최측 정보 수정
	int update(Corporate corp);


	// [주최자] 회원가입
	int signUp(Corporate corp);


	int deleteUseYN(int id);
	
	
	// mypage 주최자 정보 수정
	int updateAccount(ArtagitUserDetails user);


	int chkId(String loginId);
}
