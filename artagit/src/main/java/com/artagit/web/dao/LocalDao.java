package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Local;

@Mapper
public interface LocalDao{
	
	Local get(int id);
}
