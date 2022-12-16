package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.ExhibitionDao;
import com.artagit.web.entity.Exhibition;

@Service
public class DefaultExhibitionService implements ExhibitionService {
	
	@Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
	private ExhibitionDao exhDao; // DB를 가져오는 용도

	@Override
	// 전시 등록 메서드
	public int reg(Exhibition exhibition) {
		exhDao.insert(exhibition);
	}

	@Override
	// 페이지 지정해서 목록 조회하는 메서드
	public List<Exhibition> getList(int page) {
		
		int size = 6;
		int offset = (page-1)*size;
		
		List<Exhibition> list = exhDao.getList(offset, size);
		
		return list;
	}

	@Override
	// 전시 상세 정보 가져오는 메서드
	public Exhibition getExhById(int id) {
		
		Exhibition exh = exhDao.get(id);
		
		return exh;
	}
}
