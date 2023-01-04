package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.CorporateDao;
import com.artagit.web.entity.Corporate;

@Service
public class DefaultCorporateService implements CorporateService{
	
	@Autowired
	private CorporateDao corporateDao;
	
	@Override
	public Corporate getCorpById(int id) {
		
		Corporate corporate = corporateDao.get(id);
		
		return corporate;
	}

	
	// [주최자] 나의 등록전시 수정 -> 주최측 정보 수정
	@Override
	public int update(int id) {
		int result = corporateDao.update(id);
		return result;
	}
	
}
