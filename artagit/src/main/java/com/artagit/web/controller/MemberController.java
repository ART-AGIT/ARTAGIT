package com.artagit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.Member;
import com.artagit.web.service.MemberService;


@Controller
@RequestMapping("/user") //템플릿 기준
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
	public String reg(Member member){

		int result = service.signUp(member);
		System.out.println("insert 결과 => " + result);
		System.out.println("가입된 member => " + member);
		return "redirect:/";
		
	}
	
	//===== 회원 탈퇴 (useYN 변경) ==================================
	@GetMapping("corp")
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

	
	
	
	//===== 업체 회원 정보 수정 ==================================
	// 수정화면 요청
//	@GetMapping("corp")
//	public String updateCorp(Member member) {
//		
//		
//	}
	
	
	
	
	
	
}