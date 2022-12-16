package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Component;
>>>>>>> dev
import org.springframework.stereotype.Service;

import com.artagit.web.dao.MemberDao;
import com.artagit.web.entity.Member;

<<<<<<< HEAD
@Service
public class DefaultMemberService implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int reg(Member member) {
		int result;
		result = memberDao.insert(member);
		return result;
=======
@Component
public class DefaultMemberService implements MemberService{
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public void insertMember(Member member) {
		memberDao.insert(member);

>>>>>>> dev
	}

}
