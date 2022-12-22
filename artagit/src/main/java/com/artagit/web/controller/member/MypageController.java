package com.artagit.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.service.ExhibitionService;


@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired 
	private ExhibitionService exhService;
	
	
	//예매내역리스트 
	@GetMapping("/review/list")
	public String list() {
		int memId =1;
		exhService.getListById(memId);
		return "member/mypage/booking-list";
		
	}
	
	
	
	
//	//리뷰등록
//	@PostMapping("/review/reg")
//	public String list() {
//		
//		
//		return null;
//		
//	}
}