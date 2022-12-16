package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.MemberDao;
import com.artagit.web.entity.Member;

@Component
public class DefaultMemberService implements MemberService{
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public void insertMember(Member member) {
		memberDao.insert(member);

	}

}
