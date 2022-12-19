package com.artagit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======
import org.springframework.ui.Model;
>>>>>>> dev
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.Member;
import com.artagit.web.service.MemberService;

<<<<<<< HEAD
import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
=======
@Controller
@RequestMapping("/") //템플릿 기준
public class MemberController {
	
	@Autowired
	private MemberService service;
>>>>>>> dev
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	
<<<<<<< HEAD
	
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
		
=======
	public MemberController(MemberService service) {
		this.service = service;
	}
	
	@GetMapping("/login")
	public String list(Model model) {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup(Model model){
>>>>>>> dev
		return "signup";
	}
	
	@PostMapping("signup")
<<<<<<< HEAD
	public String create(Member form){
		
//		Member member = form;
		int result = memberService.reg(form);
		System.out.println(result);
		System.out.println(form);
		return "redirect:/";
		
	}
	
	
	
=======
	public String create(Member form) {
		
		service.insertMember(form);
		return "redirect:signup";
		
	}
<<<<<<< HEAD
}
=======
>>>>>>> dev
}
>>>>>>> dev
