package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.ExhLikeDao;
import com.artagit.web.entity.ExhLike;
import com.artagit.web.entity.ExhLikeList;

@Service
public class DefaultExhLikeService implements ExhLikeService {
	
	@Autowired
	ExhLikeDao exhLikeDao;
	
	@Override
	public List<ExhLike> getListByMemberId(int memId) {
		
		List<ExhLike> lists = exhLikeDao.getLikeByMemId(memId);
		
		
		return lists;
	}

	@Override
	public int getCount(int id) {
		int getCount = exhLikeDao.getCount(id);
		return getCount;
	}

	// 좋아요 전시 더보기
	@Override
	public List<ExhLikeList> getLikeListById(int id, int page) {
		int size =6;
		int offset = (page-1)*size;
		List<ExhLikeList> list = exhLikeDao.getLikeListById(id,size,offset);
		return list;
	}
	
	

}
