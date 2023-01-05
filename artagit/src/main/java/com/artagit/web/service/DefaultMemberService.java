package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.artagit.web.dao.MemberDao;
import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Member;


@Service
public class DefaultMemberService implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	// 회원가입 메서드
	@Override
	public int signUp(Member member) {
		String password = member.getPassword();
		String encPassword = passwordEncoder.encode(password);
		
		member.setPassword(encPassword); // 인코딩한 비번을 member 객체에 담는다.
		member.setRoleId(2); // 일반회원에게는 roleId를 2번으로 부여해준다.
		
		int result = memberDao.insert(member);
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
