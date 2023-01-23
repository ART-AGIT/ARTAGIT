package com.artagit.web.service;

import com.artagit.web.entity.Member;

public interface MemberService {
	
	int signUp(Member member);

//	void insertMember(Member member);

	void deleteUseYN(int id);
//	void deleteUseYN(Member member);

	int chkId(String loginId);
	
	int update(Member member);
	
	Member get(int id);
	
	Member getByUserName(String loginId);
	
	// 사용자가 입력한 정보로 ID 확인
	Member getId(String name, String email);

	// PW 찾을 때, 입력한 ID가 DB에 존재하는지 확인
	int checkUser(Member member, String loginId, String email);
	
}
