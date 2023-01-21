package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.NoticeDao;
import com.artagit.web.entity.Notice;

@Service
public class DefaultNoticeService implements NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<Notice> getList(int page) {
//		List<Notice> list = noticeDao.getListById(page);
		int size = 6;
		int offset = (page-1)*size;
		
		return noticeDao.getList(offset, size);
	}

	@Override
	public List<Notice> getListInit(int page, int size) {
		// TODO Auto-generated method stub
		return noticeDao.getListInit(page,3);
	}

	@Override
	public List<Notice> getListByCategory(int page, int category) {
		// TODO Auto-generated method stub
		int size = 3;
		return noticeDao.getListByCategory(page,category,size);
	}

	@Override
	public Notice getNoticeById(int id) {
		// TODO Auto-generated method stub
		return noticeDao.getNoticeById(id);
	}

	@Override
	public int hitUp(int id) {
		// TODO Auto-generated method stub
		return noticeDao.hitUp(id);
	}

}
