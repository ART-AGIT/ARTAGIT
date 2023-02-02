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
		//인코딩1
		member.setPassword(encPassword); // 인코딩한 비번을 member 객체에 담는다.
		
		member.setRoleId(2); // 일반회원에게는 roleId를 2번으로 부여해준다.
		
		int result = memberDao.insert(member);
		return result;
	}

//======== 회원 탈퇴 ==================
	@Override
	public int deleteUseYN(int id) {

		int result = memberDao.deleteUseYN(id);

		return result;
	}
	
	// 아이디 중복 여부
	@Override
	public int chkId(String loginId) {
		int cnt = memberDao.chkId(loginId);
		return cnt;
	}

	//=========== 회원수정 =================
	@Override
	public int update(Member member) {
//		String encPassword = passwordEncoder.encode(member.getPassword());
//		member.setPassword(encPassword);
		int result = memberDao.update(member);
		
		return result;
	}

	@Override
	public Member get(int id) {
		return memberDao.get(id);
	}
	
	//=========== PW 찾을 때, 입력한 id로 회원 객체 가져오기 =================
	@Override
	public Member getByUserName(String loginId) {
		return memberDao.getByUserName(loginId);
	}

	//=========== PW 찾을 때, 입력한 id, email이 DB에 존재하는지 확인 =================
	@Override
	public int checkUser(Member member, String loginId, String email) {
		
		int result = 1;
		 
		 String memId = member.getLoginId();
		 String memEmail = member.getEmail();
		 
		System.out.println("사용자 id: " + memId);
		System.out.println("사용자 email: " + memEmail);
		
 
//		if(!(loginId.equals(memId)) || member == null) {
//			System.out.println("존재하지 않는 ID 예요ㅋㅋ.");
//			result = 1;
//		} else 
		
		if (!(email.equals(memEmail))) {
			System.out.println("이메일을 정확하게 입력해 주세요.");
			result = 2;
		} else { // (loginId == memId) && (email == memEmail)			
			System.out.println("우리 회원이에요. 정보가 일치해요.");
		}
		
		 return result;
	}

	@Override
	public Member getId(String name, String email) {
		return memberDao.getId(name, email);
	}
}
