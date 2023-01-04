package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Museum;

@Mapper
public interface CorporateDao {
	
	Corporate get(int id);

	int update(Corporate corporate);
	//성공하면 1 실패하면 0
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// (주최자가 전시정보 수정 시) 주최측에 대한 정보 수정 
	int update(int id);
}
