package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Role;

@Mapper
public interface RoleDao {

	Role getMemberByUserName(String username);

	Role getCorpByUserName(String username);

}
