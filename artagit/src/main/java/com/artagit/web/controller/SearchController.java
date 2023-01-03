package com.artagit.web.controller;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.MuseumService;

@Controller
@RequestMapping("/")
public class SearchController {
	
	@Autowired
	private ExhibitionService service;
	
	@Autowired
	private MuseumService museumService;
	
	
	/********************** 검색 **********************/
	@GetMapping("exhibition/search")
	public String list( // 전시목록 불러오기
			@RequestParam(defaultValue = "", name = "q") String query,
			Model model) throws SQLSyntaxErrorException {
		
		List<Exhibition> lists = service.getListBySearch(query);
		
		model.addAttribute("lists", lists);

		return "exhibition/list";
	}
}

// pathvariable
// requestParam 
