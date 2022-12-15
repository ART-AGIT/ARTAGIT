package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.ExhibitionDao;
import com.artagit.web.entity.Exhibition;

@Service
public class DefaultExhibitionService implements ExhibitionService {
	
	@Autowired
	private ExhibitionDao exhibitionDao;
	
	public DefaultExhibitionService() {

	}
	
	public DefaultExhibitionService(ExhibitionDao exhibitionDao) {

		this.exhibitionDao = exhibitionDao;
	}

	
	


	@Override
	public int reg(Exhibition exhibition) {
		
		exhibitionDao.insert(exhibition);
		
		// TODO Auto-generated method stub
		return exhibition.getId();
	}

	@Override
	public List<Exhibition> getList(int page) {
		
		List<Exhibition> list = exhibitionDao.getList(0, null, null);
		
		return list;
	}

}
