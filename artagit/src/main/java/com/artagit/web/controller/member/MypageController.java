//package com.artagit.web.controller.member;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.artagit.web.entity.Exhibition;
//import com.artagit.web.service.ExhibitionService;
////import com.artagit.web.service.MyPageService;
//
//
//@Controller
//@RequestMapping("/mypage")
//public class MypageController {
//	
//	@Autowired 
//	private ExhibitionService exhService;
//	
//	@Autowired
////	private MyPageService myPageService;
//	
//	//예매내역리스트 
//	@GetMapping("/review/list")
//	public String list(Model model) {
//		int memId =58;
//		List<Exhibition> list = exhService.getListById(memId);
//		model.addAttribute("list",list);
//		return "member/mypage/booking-list";
//		
//	}
//	
//	/*
//	@PostMapping("/review/reg")
//	public String reg() {
//		int memId = 58;
//		myPageService.reg(memId);
//		return null;
//	}
//	*/
//	
//	
//	
//	
////	//리뷰등록
////	@PostMapping("/review/reg")
////	public String list() {
////		
////		
////		return null;
////		
////	}
//}