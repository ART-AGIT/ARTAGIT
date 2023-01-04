package com.artagit.web.controller.corporate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.Corporate;
import com.artagit.web.service.CorporateService;

@Controller
@RequestMapping("/corporate")
public class CorporateController {

	@Autowired
	private CorporateService service;
	
	@GetMapping("account-edit")
	public String deleteUseYN() {
		
		return "corporator/mypage/account-edit";
	}
	
	
//	@PostMapping("{id}")
//	public String deleteUseYN(@RequestParam("id") int id){
//		// 되는지 확인용
//		int memid=51;
//		String useYN2 = "Y";
//		service.deleteUseYN(memid,useYN2);
////		
//		return "corporator/mypage/account-edit";
////		return "redirect:/";
//	}
	
	// 회원가입
	@GetMapping("signup")
	public String signUp() {
		return "signup-corp";
	}
	
	@PostMapping("signup")
	public String reg(Corporate corp){

		int result = service.signUp(corp);
		System.out.println("insert 결과 => " + result);
		System.out.println("가입된 corporate => " + corp);
		return "redirect:/";
		
	}
}
