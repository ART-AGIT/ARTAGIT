package com.artagit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.Member;
import com.artagit.web.service.MemberService;


@Controller
@RequestMapping("/") //템플릿 기준
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	@GetMapping("login")
	public String list(Model model) {
		
		return "login";
	}
	
//	@PostMapping("login")
//	public String list()
//	
	
	@GetMapping("signup")
	public String signup() {
		
		return "signup";
	}
	
	@PostMapping("signup")
	public String reg(Member member){
		
//		Member member = form;
		int result = service.reg(member);
		System.out.println(result);
		System.out.println(member);
		return "redirect:/";
		
	}
	
}