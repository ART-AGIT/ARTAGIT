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

	// [주최자] 나의 등록전시 수정 -> 지역 정보 수정
	@Override
	public int update(Local local) {
		int result = localDao.update(local);
		return result;
	}
	
}
