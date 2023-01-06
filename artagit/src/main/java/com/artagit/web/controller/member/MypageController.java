package com.artagit.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Member;
import com.artagit.web.service.ExhibitionService;
//import com.artagit.web.service.MyPageService;
import com.artagit.web.service.MemberService;


@Controller
@RequestMapping("/member/mypage")
public class MypageController {
	
	@Autowired 
	private ExhibitionService exhService;
	
	@Autowired
	private MemberService memberService;
//	@Autowired
//	private MyPageService myPageService;
	
//	//예매내역리스트 
//	@GetMapping("/review/list")
//	public String list(Model model) {
//		int memId =58;
//		List<Exhibition> list = exhService.getListById(memId);
//		model.addAttribute("list",list);
//		return "member/mypage/booking-list";
//		
//	}
//	
//	/*
//	@PostMapping("/review/reg")
//	public String reg() {
//		int memId = 58;
//		myPageService.reg(memId);
//		return null;
//	}
//	*/
//	
//	
//	
//	
////	//리뷰등록
////	@PostMapping("/review/reg")
////	public String list() {
////		
////		
////		return null;
////		
////	}

//===================회원수정===================
	@GetMapping("/account-edit")
	public String update(@AuthenticationPrincipal ArtagitUserDetails user, Model model, Member member) {
		//회원수정페이지불러올때 회원가입할때정보불러오기 user쓰기

		model.addAttribute("user",user);
		//System.out.println(user.getId());
		//memberService.update(user);
		
		
		return "member/mypage/account-edit";
	}
	
	@PostMapping("/account-edit")
	public String modify(@AuthenticationPrincipal ArtagitUserDetails user, Model model, Member member) {
		
//		
//		System.out.println("user"+user);
//		System.out.println("member"+member);
		
		
		member.setPassword(member.getPassword()); 
		
//		memberService.update(member);
//		Member memb = memberService.get(member.getId());

//		System.out.println("member"+memb);
		model.addAttribute("user",user);
		
		
		
		return "member/mypage/account-edit";
	}


}
	
	
	
	
