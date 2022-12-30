package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.Notice;

public interface NoticeService {

	List<Notice> getList(int page);
	List<Notice> getListByCategory(int category);

}
