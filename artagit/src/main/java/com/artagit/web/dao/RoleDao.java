package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Role;

@Mapper
public interface RoleDao {

	Role getListByUserName(String username);

}
