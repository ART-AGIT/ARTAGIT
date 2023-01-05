package com.artagit.web.controller.corporate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.service.CorporateService;

@Controller
//@ResponseBody
@RequestMapping("/corp")
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
		return "redirect:../";
		
	}
	
	//===== 회원 탈퇴 (useYN 변경) ==================================
	
	@GetMapping("account-edit")
	public String accountEdit() {
		return "corporator/mypage/account-edit";
	}
	
	@GetMapping("account-edit/delete")
	public String deleteUseYN(
			@AuthenticationPrincipal ArtagitUserDetails user){
		service.deleteUseYN(user.getId());
		return "redirect:/user/logout";
	}
	
	//===== 업체 회원 정보 수정 ==================================
//	
//	@GetMapping("account-edit")
//	public String deleteUseYN(
//			@AuthenticationPrincipal ArtagitUserDetails user){
//		service.deleteUseYN(user.getId());
//		return "redirect:/user/logout";
//	}
//	
//	
	
	
	
	
}
