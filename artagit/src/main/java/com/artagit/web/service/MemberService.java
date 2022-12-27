package com.artagit.web.service;

import com.artagit.web.entity.Member;

public interface MemberService {
	
	int reg(Member member);

//	void insertMember(Member member);

	void deleteUseYN(int id,String useYN);
//	void deleteUseYN(Member member);
	
//	로그인
	Member getMemberByName(String loginId);
}
