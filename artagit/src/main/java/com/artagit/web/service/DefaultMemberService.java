package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.artagit.web.dao.MemberDao;
import com.artagit.web.entity.ArtagitUserDetails;
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

//========회원 탈퇴 ==================
	
	@Override
	public void deleteUseYN(int id,String useYN) {
//	public void deleteUseYN(Member member) {
		 memberDao.deleteUseYN(id,useYN);
//		memberDao.deleteUseYN(member);
		
//		return result;
	}


	//===========회원수정=================
	@Override
	public int update(Member member) {
		
		return memberDao.update(member);
		
		
	}

	@Override
	public Member get(int id) {
		
		return memberDao.get(id);
		
		
	}
	



}
