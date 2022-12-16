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
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	@GetMapping("/login")
	public String list(Model model) {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model){
		return "signup";
	}
	
	@PostMapping("signup")
	public String create(Member form) {
		Member member = form;
		
		service.insertMember(member);
		return "redirect:signup";
		
	}
}
