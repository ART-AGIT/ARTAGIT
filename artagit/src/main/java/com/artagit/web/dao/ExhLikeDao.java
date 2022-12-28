package com.artagit.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.ExhLike;

@Mapper
public interface ExhLikeDao {

	int add(ExhLike exhLike);

	int delete(ExhLike exhLike);

	int getLikeByExhId(int exhId);

	int getLikeByMemId(int memId);

	int count(int exhId);

}
