package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Exhibition;

public interface CorporateService {

	Corporate getCorpById(int id);

	
	// [주최자] 나의 등록전시 수정 -> 주최측 정보 수정
	int update(Corporate corp);


	// [주최자] 회원가입
	int signUp(Corporate corp);
	
	// [주최자] 입력한 정보로 ID 확인
	Corporate getId(String name, String email);

	int deleteUseYN(int id);
	
	
	// mypage 주최자 정보 수정
	int updateAccount(ArtagitUserDetails user);


	int chkId(String loginId);


	List<Exhibition> getListByDateId(int page, int state, int corpId);
}
