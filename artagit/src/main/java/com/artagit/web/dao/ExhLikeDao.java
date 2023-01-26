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

	//member - 좋아요 전시 건수 가져오기
	int getCount(int id);



}
