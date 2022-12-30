package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.NoticeDao;
import com.artagit.web.entity.Board;
import com.artagit.web.entity.Notice;

@Service
public class DefaultNoticeService implements NoticeService {
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> getList(int page) {
		int size = 1;
		int offset = (page-1)*size;
		
		return noticeDao.getList(offset,size,1);
	}

	@Override
	public List<Notice> getListByCategory(int categoryId) {
		// TODO Auto-generated method stub
		int page = 1;
		int size = 6;
		int offset = (page-1)*size;
		List<Notice> list = noticeDao.getList(offset,size,categoryId);
		
		return list;
	}
	}


