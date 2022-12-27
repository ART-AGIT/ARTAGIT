package com.artagit.web.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
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
	
	int insert(Member member);
	int update(Member member);
	
	void deleteUseYN(int id, String useYN); // 회원 탈퇴
//	void deleteUseYN(Member member);
	// 일반회원 로그인
	Member getByName(String loginId);
}
