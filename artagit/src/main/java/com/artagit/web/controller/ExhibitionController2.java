package com.artagit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Museum;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.MuseumService;

@Controller
@RequestMapping("/exhibition/")
public class ExhibitionController2 {
	
	@Autowired
	private ExhibitionService service;
	
	@Autowired
	private MuseumService museumService;
	
	
	/********************** 전시조회 시작 **********************/
	@GetMapping("list")
	public String list( // 전시목록 불러오기
			@RequestParam(defaultValue = "1", name = "p") int page,
			Model model) {
		
		List<Exhibition> lists = service.getList(page,0,0,0);
		
		model.addAttribute("lists", lists);
		
		return "exhibition/list";
	}
	
	@GetMapping("{id}") // 전시상세 불러오기
	public String detail(
			@PathVariable("id") int exhId,
			Model model) {
		
		
		Exhibition exh = service.getExhById(exhId);
		model.addAttribute("exh", exh);
		Museum museum = museumService.getMuseumById(exh.getMuseumId());
		model.addAttribute("museum", museum);
		
		int count = service.countOfLike(exhId);
		model.addAttribute("count",count);
		System.out.println(count);
		System.out.println("전시관 id========>"+exh.getMuseumId());
		System.out.println("전시관 name========>"+museum.getName());
		
		return "exhibition/detail";
	}
	
   /********************** 전시조회 끝 **********************/
	

}

// pathvariable
// requestParam 
