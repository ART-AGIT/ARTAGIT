package com.artagit.web.service;

import java.util.List;
import com.artagit.web.entity.Notice;

// 직접적인 서비스 모음
public interface NoticeService {
	
	// 공지 목록를 불러오는 메서드 
	List<Notice> getList(int page);
}