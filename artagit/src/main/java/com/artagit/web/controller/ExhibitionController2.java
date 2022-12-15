//package com.artagit.web.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.artagit.web.entity.Exhibition;
//import com.artagit.web.service.ExhibitionService;
//
//@Controller
//@RequestMapping("/exhibition/")
//public class ExhibitionController {
//	
//	@Autowired
//	private ExhibitionService service;
//	
//	public ExhibitionController() {
//
//	}
//
//	public ExhibitionController(ExhibitionService service) {
//		this.service = service;
//	}
//
//	@GetMapping("list")
//	public String getList(Model model) {
//		
//		List<Exhibition> lists = service.getList(0);
//		model.addAttribute("lists", lists);
//		
//		return "exhibition/list";
//	}
//	
//
//}
