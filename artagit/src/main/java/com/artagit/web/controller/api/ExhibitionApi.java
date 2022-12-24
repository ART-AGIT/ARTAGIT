package com.artagit.web.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.service.ExhibitionService;

@RestController
@RequestMapping("api/")
public class ExhibitionApi {
	
	@Autowired
	private ExhibitionService service;
	
	
	@GetMapping("lists")
	public List<Exhibition> list(
			@RequestParam(defaultValue = "1", name = "p") int page,
			@RequestParam("m") int museum, 
			@RequestParam("s") int state,
			@RequestParam("c") int category){
		
		System.out.print(category);
		
		List<Exhibition> list = service.getListByCategory(page, museum, state, category);
		
		return list;
	}
	

}
