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
	
}
