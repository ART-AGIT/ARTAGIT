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



	@Override
	public int chkId(String loginId) {
		int cnt=corporateDao.chkId(loginId);
		return cnt;
	}

	// [주최자] 입력한 정보로 ID 확인
	@Override
	public Corporate getId(String name, String email) {
		return corporateDao.getId(name, email);
	}
}
