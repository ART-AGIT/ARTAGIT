package com.artagit.web.service;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;

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
	
	// 로그인 id로 계정 정보가 존재하는지 확인
	Corporate getByUserName(String loginId);
	
	// PW 찾을 때, 입력한 ID가 DB에 존재하는지 확인
	int checkUser(Corporate corp, String loginId, String email);
}
