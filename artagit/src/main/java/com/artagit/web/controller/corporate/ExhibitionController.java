package com.artagit.web.controller.corporate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.service.ExhibitionService;

@Controller("corporaterController")
@RequestMapping("corp/exh/")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService service;
	
	//나의 등록전시
	@GetMapping("list")
	public String list(Model model) {
			//@RequestParam(name="memId")int memId,Model model) {
		int memId=1;
		List<Exhibition> list = service.getListById(memId);
		
		int countOfExh = service.countOfExh(memId);
		model.addAttribute("list",list);
		System.out.println(countOfExh);
		model.addAttribute("countOfExh",countOfExh);
		System.out.println(list);
		return "corporator/mypage/exh-list";
	}
	
	
}
