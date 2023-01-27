package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.CorporateDao;
import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;

@Service
public class DefaultCorporateService implements CorporateService{
	
	@Autowired
	private CorporateDao corporateDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Corporate getCorpById(int id) {
		
		Corporate corporate = corporateDao.get(id);
		
		return corporate;
	}

	
	// [주최자] 나의 등록전시 수정 -> 주최측 정보 수정
	@Override
	public int update(Corporate corp) {
		int result = corporateDao.update(corp);
		return result;
	}

	// [주최자] 회원가입
	@Override
	public int signUp(Corporate corp) {
		String password = corp.getPassword();
		String encPassword = passwordEncoder.encode(password);
		
		corp.setPassword(encPassword); // 인코딩한 비번을 member 객체에 담는다.
		corp.setRoleId(2); // 일반회원에게는 roleId를 2번으로 부여해준다.
		
		int result = corporateDao.insert(corp);
		return result;
	}


	@Override
	public int deleteUseYN(int id) {
		int result = corporateDao.deleteYN(id);
		
		return result;
	}

	// 주최자 정보 수정
	@Override
	public int updateAccount(ArtagitUserDetails user) {
		// TODO Auto-generated method stub
		return corporateDao.updateAccount(user);
	}

	// [주최자] 입력한 정보로 ID 확인
	@Override
	public Corporate getId(String name, String email) {
		return corporateDao.getId(name, email);
	}

	
	//=========== PW 찾을 때, 입력한 id로 회원 객체 가져오기 =================
	@Override
	public Corporate getByUserName(String loginId) {
		return corporateDao.getByUserName(loginId);
	}
	
	
	//=========== PW 찾을 때, 입력한 id, email이 DB에 존재하는지 확인 =================
	@Override
	public int checkUser(Corporate corp, String loginId, String email) {
		
		int result = 1;
		 
		 String corpId = corp.getLoginId();
		 String corpEmail = corp.getEmail();
		 
		System.out.println("사용자 id: " + corpId);
		System.out.println("사용자 email: " + corpEmail);
		
 
//		if(!(loginId.equals(memId)) || member == null) {
//			System.out.println("존재하지 않는 ID 예요ㅋㅋ.");
//			result = 1;
//		} else 
		
		if (!(email.equals(corpEmail))) {
			System.out.println("이메일을 정확하게 입력해 주세요.");
			result = 2;
		} else { // (loginId == memId) && (email == memEmail)			
			System.out.println("우리 회원이에요. 정보가 일치해요.");
		}
		
		 return result;
	}



}
