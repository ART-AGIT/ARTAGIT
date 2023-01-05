package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Museum;

@Mapper
public interface CorporateDao {
	
	Corporate get(int id);

	//성공하면 1 실패하면 0
//	int update(Corporate corporate);
	int update(Integer id);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// (주최자가 전시정보 수정 시) 주최측에 대한 정보 수정 
	int update(int id);
	
	// 회원가입 메서드
	int insert(Corporate corporate);
	
	// 주최자회원 로그인 시 권한 확인을 위해 호출되는 메서드 
	Corporate getByUserName(String username);
}
