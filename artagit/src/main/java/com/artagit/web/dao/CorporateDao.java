package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Museum;

@Mapper
public interface CorporateDao {
	
	Corporate get(int id);
	
}
