package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.ExhLike;
import com.artagit.web.entity.ExhLikeList;

public interface ExhLikeService {

	List<ExhLike> getListByMemberId(int id);
	
	int getCount(int id);

	// 좋아요 전시 더보기
	List<ExhLikeList> getLikeListById(int id, int page);
	

}
