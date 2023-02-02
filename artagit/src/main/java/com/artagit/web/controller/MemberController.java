package com.artagit.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Member;
import com.artagit.web.mail.MailService;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.MemberService;


@Controller
@RequestMapping("/user") // 템플릿 기준
public class MemberController {

	@Autowired
	private MemberService service;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private CorporateService corpService;
	
	///////////////// test ////////////////
//	@GetMapping("/test/login")
//	public @ResponseBody String testLogin(Authentication authentication, @AuthenticationPrincipal ArtagitUserDetails userDetails) {
//		// @AuthenticationPrincipal 어노테이션을 통해 session 정보에 접근할 수 있다.
//		System.out.println("/test/login ==============");
//		ArtagitUserDetails artagitUserDetails = (ArtagitUserDetails)authentication.getPrincipal();
//		System.out.println("authentication: " + authentication.getPrincipal());
//		
//		System.out.println("userDetails: " + userDetails.getLoginId());
//		return "세션 정보 확인하기";
//	}
//	
//	@GetMapping("/test/oauth/login")
//	public @ResponseBody String testOAuthLogin(Authentication authentication, @AuthenticationPrincipal OAuth2User oauth) {
//		// @AuthenticationPrincipal 어노테이션을 통해 session 정보에 접근할 수 있다.
//		System.out.println("/test/oauth/login ==============");
//		OAuth2User oauth2User = (OAuth2User)authentication.getPrincipal();
//		System.out.println("authentication: " + oauth2User.getAttributes());
//		System.out.println("oauth2User: " + oauth.getAttributes());
//		
//		return "OAuth(소셜) 세션 정보 확인하기";
//	}
	
	
	@GetMapping("login")
	public String login() {
		//System.out.println("멤버의 비번"+ );
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
		System.out.println("가입된 member => " + member.getPassword());
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
	@PostMapping("findId")
	@ResponseBody
	public String findId(@RequestBody Map<String, String> info) {
		System.out.println("findId 진입");
		
		String name = info.get("name");
		String email = info.get("email");
		
		String id = null ;
		
		// 입력한 아이디로 멤버 객체 생성
		Member member = service.getId(name, email);
		Corporate corp = null;
		
		if(member == null) { 								// member(일반회원) 가 아니면
			corp = corpService.getId(name, email); 			// corp(기업회원) 인지 확인한다.
			if (corp != null) { 							// corp(기업회원) 이 맞으면
				id = corp.getLoginId(); 					// id를 얻어온다.
				return id;
			}
		} else  											// member(일반회원) 가 맞으면
			id = member.getLoginId(); 						// id를 얻어온다.
		
		if(id == null)     // id 가 초기값(null) 그대로이면 우리 회원이 아닌 것이므로
			id = "비회원";   // return 값인 id에 "비회원"을 담아서 return 한다.
						   // id 가 null이 아니면 담긴 id값 그대로 클라이언트쪽으로 return 한다.
		return id;
	}

	// 이메일로 임시비밀번호 보내기
	@PostMapping("sendEmail")
	@ResponseBody
	public int sendEmail(@RequestBody Map<String, String> info) throws Exception {
		System.out.println("sendEmail 진입");
		
		String loginId = info.get("loginId");
		String email = info.get("email");
		
		System.out.println("입력한 loginId===>" + loginId);
		System.out.println("입력한 email===>" + email);

		// 입력한 아이디로 멤버 객체 생성
		Member member = service.getByUserName(loginId);
		Corporate corp = null;
		System.out.println("입력한 정보로 가져온 member===>" + member);

		int result = 0;
		String id = null;
		
		// 회원인지 먼저 확인
		if (member == null ) {
			corp = corpService.getByUserName(loginId);
			if(corp != null) {
				result = corpService.checkUser(corp, loginId, email);
				id = corp.getLoginId(); // 회원 id를 메일 양식에 보여줄라고 
			}
		} else {
			result = service.checkUser(member, loginId, email);
			id = member.getLoginId();
		}

		// 일반이든, 업체든 ... 회원이 맞으면,
		if(result == 1) {
			String tmpPwd = mailService.getTmpPassword(); // 임시 비밀번호 생성
//			id = member.getLoginId(); // 누구누구님을 메일 양식 에서 보여줄라고 
			if(member != null) {
				member.setPassword(tmpPwd); // 임시비번을 멤버 객체에 담기
				service.update(member);		// 멤버객체를 update 하기				
			} else {
				corp.setPassword(tmpPwd);
				corpService.update(corp);
			}
			mailService.sendMail(email, id, tmpPwd); // 메일 발송
			
			System.out.println("메일 발송 완료!! 메일함을 확인해 주세요.");
			
			return result;
		} else { // return == 2
			System.out.println("회원은 맞는데 email이 틀렸어요");// 회원이 아니면 그대로 return
		}
		return result;
	}
	
	
	
	
	
	// 사업자 회원 가입
	@GetMapping("/corp/signup")
	public String signUp() {
		return "signup-corp";
	}
	
	@PostMapping("/corp/signup")
	public String reg(Corporate corp){

		int result = corpService.signUp(corp);
		System.out.println("insert 결과 => " + result);
		System.out.println("가입된 corporate => " + corp);
		return "redirect:/";
		
	}
	
	
}