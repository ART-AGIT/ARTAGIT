package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.ExhibitionView;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Museum;

@Mapper
public interface CorporateDao {
	
	Corporate get(int id);
	
	// (주최자가 전시정보 수정 시) 주최측에 대한 정보 수정 (성공하면 1 실패하면 0)
	int update(Corporate corporate);
	
	// 회원가입 메서드
	int insert(Corporate corporate);
	
	// 주최자회원 로그인 시 권한 확인을 위해 호출되는 메서드 
	Corporate getByUserName(String username);
	
	// 사용자가 입력한 정보로 ID 확인
	Corporate getId(String name, String email);
	
	int deleteYN(int id);

	// mypage 주최자 정보 수정
	int updateAccount(ArtagitUserDetails user);

	// 아이디 중복 확인
	int chkId(String loginId);

	// 주최자가 등록한 전시date필터링
	List<Exhibition> getListByDateId(int offset, int state, int corpId ,int size);


}
