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
	
	// PW 찾을 때, 입력한 ID가 DB에 존재하는지 확인
	int checkUser(Member member, String loginId, String email);
	
	// 임시비밀번호로 비밀번호 업데이트하기
	int updatePassword(String tmpPassword, Member member);
}
