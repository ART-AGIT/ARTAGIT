package com.artagit.web.service;

import org.springframework.ui.Model;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Member;

public interface MemberService {
	
	int signUp(Member member);

//	void insertMember(Member member);

	void deleteUseYN(int id);
//	void deleteUseYN(Member member);

	int chkId(String loginId);
	
	int update(Member member);
	Member get(int id);
    
	//void update(Model model);

}
