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
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Member;
import com.artagit.web.mail.MailService;
import com.artagit.web.service.MemberService;


@Controller
@RequestMapping("/user") // 템플릿 기준
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private MailService mailService;

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

	
	@PostMapping("checkUser/{id}/{email}")
	@ResponseBody
	public int sendEmail(@PathVariable("id") String loginId, @PathVariable("email") String email) throws Exception {
		System.out.println("sendEmail 진입");

		// 입력한 아이디로 멤버 객체 생성
		Member member = service.getByUserName(loginId);
		System.out.println("입력한 loginId===>" + loginId);
		System.out.println("입력한 email===>" + email);
		System.out.println("입력한 정보로 가져온 member===>" + member);
		
		// 입력한 정보가 일치하는지 확인
		int result = service.checkUser(member, loginId, email);
		System.out.println("result===>" + result);
		
		// 회원이 맞으면,
		if(result == 0) {
			String tmpPwd = mailService.getTmpPassword(); // 임시 비밀번호 생성
			member.setPassword(tmpPwd); // 임시비번을 멤버 객체에 담기
			service.update(member);		// 멤버객체를 update 하기
			mailService.sendMail(email, tmpPwd); // 메일 발송
			
			System.out.println("메일 발송 완료!! 메일함을 확인해 주세요.");
		} // 회원이 아니면 그대로 return
		
			
		return result;
	}
	
	
}