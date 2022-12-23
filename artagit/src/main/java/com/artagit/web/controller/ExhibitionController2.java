package com.artagit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.service.ExhibitionService;

@Controller
@RequestMapping("/exhibition/")
public class ExhibitionController2 {
	
	@Autowired
	private ExhibitionService service;
	
	
	/********************** 전시조회 시작 **********************/
	@GetMapping("list")
	public String list( // 전시목록 불러오기
			@RequestParam(defaultValue = "1", name = "p") int page,
			Model model) {
		
		List<Exhibition> lists = service.getList(page,0,0,0);
		
		model.addAttribute("lists", lists);
		
		return "exhibition/list";
	}
	
	@GetMapping("detail") // 전시상세 불러오기
	public String detail(
			@RequestParam(defaultValue="21", name = "id") int id,
			Model model) {
		
		int exhId = 21;
		
		Exhibition exh = service.getExhById(exhId);
		model.addAttribute("exh", exh);
		return "exhibition/detail";
	}
	
   /********************** 전시조회 끝 **********************/

}
