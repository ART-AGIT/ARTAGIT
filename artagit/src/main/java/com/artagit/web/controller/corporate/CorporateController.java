package com.artagit.web.controller.corporate;

import org.springframework.beans.factory.annotation.Autowired;
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
