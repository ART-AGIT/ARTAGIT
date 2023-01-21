package com.artagit.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Member;

@Mapper
public interface MemberDao {
	List<Member> getList(
			int offset,
			int size,
			String field,
			String query);
	Member get(int id); 		// 1건 조회
	int count(String query);	// select 시 검색결과 집계(카운트)
	int updateMember(Member member);
	
	// 회원가입 메서드
	int insert(Member member);
	
	// 회원정보 수정
	int update(Member member);
	
	void deleteUseYN(int id); // 회원 탈퇴

	Member getByUserName(String username);
	
//	Member getById(String username, String );
	
	//비밀번호 변경 메서드
	public void updatePassword(String tmpPassword, String memberEmail);
	
	int chkId(String loginId);
	
	// ID & PW 찾을 때, 입력한 ID가 DB에 존재하는지 확인
	boolean checkId(String loginId);

	
}
