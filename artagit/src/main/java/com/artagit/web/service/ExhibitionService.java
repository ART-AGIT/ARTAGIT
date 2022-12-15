package com.artagit.web.service;

import java.util.List;

import com.artagit.web.entity.Exhibition;

public interface ExhibitionService {

	int reg(Exhibition exhibition);

	List<Exhibition> getList(int page);


}
