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
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhibitionService;

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
			@RequestParam(defaultValue = "1", name = "s") int state,
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
		
		int size = 0;
		List<ExhibitionView> lists = service.getListByMemberId(page,size,0,1,0,memberId);

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
		
		ExhibitionView exh = service.getExhById(exhId, memberId); // 전시 id값으로 전시 데이터 얻기
		model.addAttribute("exh", exh); // 전시정보 model에 추가
		Corporate corp = corporateService.getCorpById(exh.getCorpId()); // exh 객체에서 얻을 수 있는 corpId로 
		model.addAttribute("corp", corp);
		
		int count = service.countOfLike(exhId);
		model.addAttribute("count",count);
		
		return "exhibition/detail";
	}
	
   /********************** 전시조회 끝 **********************/
	

}

// pathvariable
// requestParam 
