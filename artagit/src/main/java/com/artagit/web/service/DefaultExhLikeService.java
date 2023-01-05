package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.ExhLikeDao;
import com.artagit.web.entity.ExhLike;

@Service
public class DefaultExhLikeService implements ExhLikeService {
	
	@Autowired
	ExhLikeDao exhLikeDao;
	
	@Override
	public List<ExhLike> getListByMemberId(int memId) {
		
		List<ExhLike> lists = exhLikeDao.getLikeByMemId(memId);
		
		
		return lists;
	}
	
	

}
