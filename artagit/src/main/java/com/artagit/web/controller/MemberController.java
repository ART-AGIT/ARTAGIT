package com.artagit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Member;
import com.artagit.web.service.MemberService;



@Controller
@RequestMapping("/user") // 템플릿 기준
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("login")
	public String login() {
		return "user/login";
	}

	@GetMapping("signup")
	public String signup() {
		return "signup";
	}

	// 회원가입
	@PostMapping("signup")
	public String reg(Member member) {

		int result = service.signUp(member);
		System.out.println("insert 결과 => " + result);
		System.out.println("가입된 member => " + member);
		return "redirect:/";

	}
	
	// 회원 탈퇴
	@GetMapping("account-edit")
	public String deleteUseYN() {
		System.out.println("account-edit");
		return "member/mypage/account-edit";
	}
	
	@GetMapping("account-edit/delete")
	public String deleteUseYN(
			@AuthenticationPrincipal ArtagitUserDetails user){
		System.out.println("탈퇴 성공했다------------------");
		service.deleteUseYN(user.getId());
		System.out.println("return하자!");
		return "redirect:/user/logout";
	}
	
	// 회원 아이디 중복 체크
	@GetMapping("signup/id-check/{value}")
	public int chkId(@PathVariable ("value") String loginId) {
		int chkId = service.chkId(loginId);
		System.out.println(loginId);
		System.out.println(chkId);
		return chkId;
	}
	
	
	
	
	
	
	
	

	
}