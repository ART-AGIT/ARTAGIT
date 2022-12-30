package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.PayList;

@Mapper
public interface PayListDao {

	List<PayList> getList(int id);

}
