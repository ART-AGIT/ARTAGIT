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

	// 공지 상세보기 
	@Override
	public Notice getNoticeById(int id) {
		return noticeDao.getNoticeById(id);
	}

}
