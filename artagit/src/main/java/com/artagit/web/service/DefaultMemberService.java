package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.artagit.web.dao.MemberDao;
import com.artagit.web.entity.Member;


@Service
public class DefaultMemberService implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int reg(Member member) {
		int result;
		result = memberDao.insert(member);
		return result;

	}

}