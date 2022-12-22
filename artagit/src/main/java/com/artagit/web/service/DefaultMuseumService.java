package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.MuseumDao;
import com.artagit.web.entity.Museum;

@Service
public class DefaultMuseumService implements MuseumService {
	
	@Autowired
	private MuseumDao museumDao;
	
	@Override
	public Museum getMuseumById(int id) {
		
		Museum museum = museumDao.get(id);
		return museum;
	}
}