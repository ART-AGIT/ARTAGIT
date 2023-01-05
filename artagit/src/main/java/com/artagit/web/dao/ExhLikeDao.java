package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.ExhLike;

@Mapper
public interface ExhLikeDao {

	int add(ExhLike exhLike);

	int delete(ExhLike exhLike);

	int getLikeByExhId(int exhId);

	List<ExhLike> getLikeByMemId(int memId);

	int count(int exhId);

}
