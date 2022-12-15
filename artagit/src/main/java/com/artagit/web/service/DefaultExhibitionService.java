package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.ExhibitionDao;
import com.artagit.web.entity.Exhibition;

@Service
public class DefaultExhibitionService implements ExhibitionService {
	
	@Autowired
	private ExhibitionDao exhDao;
	
	// 기본생성자
	public DefaultExhibitionService() {

	}
	
	public DefaultExhibitionService(ExhibitionDao exhDao) {
		this.exhDao = exhDao;
	}

	@Override
	// 인터페이스를 구현하는 메서드
	public int reg(Exhibition exhibition) {
		return exhDao.insert(exhibition);
	}

	@Override
	// 페이지 지정해서 목록 조회하는 메서드
	public List<Exhibition> getList(int page) {
		
		int size = 6;
		int offset = (page-1)*size;
		
		List<Exhibition> list = exhDao.getList(offset, size);
		
		return list;
	}
}
