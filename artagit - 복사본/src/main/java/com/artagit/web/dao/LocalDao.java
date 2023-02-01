package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Local;

@Mapper
public interface LocalDao{
	
	Local get(int id);

	// (주최자가 전시정보 수정 시) 지역에 대한 정보 수정 (성공하면 1 실패하면 0)
	int update(Local local);
}
