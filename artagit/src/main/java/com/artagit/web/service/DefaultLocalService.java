package com.artagit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.LocalDao;
import com.artagit.web.entity.Local;

@Service
public class DefaultLocalService implements LocalService{
	
	@Autowired
	private LocalDao localDao;

	@Override
	public Local getLocalById(int id) {
		
		Local local = localDao.get(id);
		
		return local;
	}

	@Override
	public int update(int id) {
		int result = localDao.update(id);
		return result;
	}

	@Override
	public int update(Local local) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
