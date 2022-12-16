package com.artagit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.Member;
import com.artagit.web.service.MemberService;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("login")
	public String list(Model model) {
		
		return "login";
	}
	
//	@PostMapping("login")
//	public String list()
//	
	
	@GetMapping("signup")
	public String create() {
		
		return "signup";
	}
	
	@PostMapping("signup")
	public String create(Member form){
		
//		Member member = form;
		int result = memberService.reg(form);
		System.out.println(result);
		System.out.println(form);
		return "redirect:/";
		
	}
	
	
	
}
