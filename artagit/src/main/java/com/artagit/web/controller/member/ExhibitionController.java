package com.artagit.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.service.ExhibitionService;

@Controller
//@RequestMapping("/corporator/mypage/")
@RequestMapping("/member/exh")

public class ExhibitionController {
	
	@Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
	private ExhibitionService service;
	
//   /********************** 전시등록 시작 **********************/
//	@GetMapping("exh-reg")
//	// 전시 등록 페이지를 불러오는 메서드
//	public String exhReg(Exhibition exhibition) {
//		
//		// return => templates/corporator/mypage/exh-reg.html
//		return "corporator/mypage/exh-reg";
//	}
//	
//	@PostMapping("exh-reg") // form 양식에 입력한 값들을 exh-reg.html 로 보낸다.
//	// 입력한 정보를 받아 DB에 등록하는 메서드
//	public String reg(Exhibition exhibition){
//		System.out.println("등록한 전시 ===> "+ exhibition);
//		
//		// form 에 입력한 값들이 exhibition 객체로 생성된다.
//	    service.reg(exhibition);
//	    
//	    return "redirect:exh-reg";
//	}
//   /********************** 전시등록 끝 **********************/
	
   /********************** 전시 결제선택 **********************/
	@GetMapping("pay")
	public String pay() {

		return "member/exhibition/pay";
	}
   /********************** 전시 예매 **********************/
	@GetMapping("booking-ticket")
	public String booking() {

		return "member/exhibition/booking-ticket";
	}	
}
