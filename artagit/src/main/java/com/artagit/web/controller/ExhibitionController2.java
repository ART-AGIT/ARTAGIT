package com.artagit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.ExhibitionView;
import com.artagit.web.entity.Museum;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhLikeService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.MuseumService;

@Controller
@RequestMapping("/exhibition/")
public class ExhibitionController2 {
	
	@Autowired
	private ExhibitionService service;

	@Autowired
	private CorporateService corporateService;
	
	
	/********************** 전시조회 시작 **********************/
	@GetMapping("list")
	public String list( // 전시목록 불러오기
			@RequestParam(defaultValue = "1", name = "p") int page,
			Model model,
			@AuthenticationPrincipal ArtagitUserDetails user
			) {
		
		//멤버 아이디 설정
		int memberId;
		//로그인하지 않으면, memberId = 0
		if(user == null)
			memberId = 0;
		else
			memberId = user.getId();
		
		List<ExhibitionView> lists = service.getListByMemberId(page,0,1,0,memberId);

		model.addAttribute("lists", lists);
		
		return "exhibition/list";
	}
	
	@GetMapping("{id}") // 전시상세 불러오기
	public String detail(
			@PathVariable("id") int exhId,
			@AuthenticationPrincipal ArtagitUserDetails user,
			Model model) {
		
		int memberId;
		if(user == null)
			memberId = 0;
		else
			memberId = user.getId();
		
		ExhibitionView exh = service.getExhById(exhId, memberId);
		System.out.println(exh);
		model.addAttribute("exh", exh);
		Corporate corp = corporateService.getCorpById(exh.getCorpId());
		model.addAttribute("corp", corp);
		
		int count = service.countOfLike(exhId);
		model.addAttribute("count",count);
		System.out.println(count);
		System.out.println("전시관 id========>"+exh.getMuseumId());
		System.out.println("전시관 name========>"+corp.getName());
		
		return "exhibition/detail";
	}
	
   /********************** 전시조회 끝 **********************/
	

}

// pathvariable
// requestParam 
