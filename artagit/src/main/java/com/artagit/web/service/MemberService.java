package com.artagit.web.service;

import com.artagit.web.entity.Member;

public interface MemberService {
	
	int signUp(Member member);

//	void insertMember(Member member);

	void deleteUseYN(int id,String useYN);
//	void deleteUseYN(Member member);
	
	
}
