package com.artagit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;
import com.artagit.web.mail.MailService;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.MemberService;

import net.minidev.json.JSONObject;


@Controller
@RequestMapping("/user") // 템플릿 기준
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private CorporateService corpService;

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
	
	// id찾기
	@GetMapping("find-id")
	public String findId() {
		return "user/find-id";
	}
	
	// pw찾기
	@GetMapping("find-pw")
	public String findPwd() {
		return "user/find-pw";
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
	
	// 아이디 찾기
	@PostMapping("findId/{name}/{email}")
	@ResponseBody
	public String findId(@PathVariable("name") String name, @PathVariable("email") String email) {
		System.out.println("findId 진입");
		
		System.out.println("입력한 name ===>" + name);
		System.out.println("입력한 email ===>" + email);
		
		// 입력한 아이디로 멤버 객체 생성
		Member member = service.getId(name, email);
		Corporate corp = corpService.getId(name, email);
		
		System.out.println("입력한 정보로 가져온 member===>" + member);
		System.out.println("입력한 정보로 가져온 corp===>" + corp);
		
		String id = "비회원";
		
		if(member == null && corp == null) {
			System.out.println("가입된 회원이 아니에요.");
		}
		else if (member !=null ){			
			id = member.getLoginId();
			System.out.println("아이디는 "+ id +"입니다.");
		} else if (corp != null){
			id = corp.getLoginId();
			System.out.println("아이디는 "+ id +"입니다.");
		}
		
		return id;
	}

	// 이메일로 임시비밀번호 보내기
	@PostMapping("sendEmail/{id}/{email}")
	@ResponseBody
	public int sendEmail(@PathVariable("id") String loginId, @PathVariable("email") String email) throws Exception {
		System.out.println("sendEmail 진입");

		System.out.println("입력한 loginId===>" + loginId);
		System.out.println("입력한 email===>" + email);

		// 입력한 아이디로 멤버 객체 생성
		Member member = service.getByUserName(loginId);
		System.out.println("입력한 정보로 가져온 member===>" + member);

		int result = 0;

		// 회원인지 먼저 확인
		if(member == null) 
			System.out.println("존재하지 않는 ID 예요."); // return == 0
		else if(member != null) {
			result = service.checkUser(member, loginId, email);
			System.out.println("result===>" + result);

			// 회원이 맞으면,
			if(result == 1) {
				String tmpPwd = mailService.getTmpPassword(); // 임시 비밀번호 생성
				String memId = member.getLoginId();
				member.setPassword(tmpPwd); // 임시비번을 멤버 객체에 담기
				service.update(member);		// 멤버객체를 update 하기
				mailService.sendMail(email, memId, tmpPwd); // 메일 발송
				
				System.out.println("메일 발송 완료!! 메일함을 확인해 주세요.");
			} else { // return == 2
				System.out.println("회원은 맞는데 email이 틀렸어요");// 회원이 아니면 그대로 return
			}
		}
		return result;
	}
	
	
}