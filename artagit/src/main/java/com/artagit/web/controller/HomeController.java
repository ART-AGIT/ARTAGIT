package com.artagit.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.ExhibitionView;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.ExhibitionService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private ExhibitionService exhService;
	
	@GetMapping()
	public String index(
			Model model,
			@AuthenticationPrincipal ArtagitUserDetails user) {
		
//		게시판
		int boardPage = 1;
		int boardSize = 4;
		int category = 0;
		List<BoardListView> boardList = boardService.getListInit(boardPage, boardSize,category);
		
//		전시
		int exhPage = 1;
		int exhSize = 4;
		//멤버 아이디 설정
		int memberId;
		//로그인하지 않으면, memberId = 0
		if(user == null)
			memberId = 0;
		else
			memberId = user.getId();
		
		List<ExhibitionView> exhList = exhService.getListByMemberId(exhPage,exhSize, 0,1,2,memberId);
	
		model.addAttribute("boardList",boardList);
		model.addAttribute("exhList", exhList);
		
		return "index";
	}
	
	@GetMapping("denied")
	public String denied() {
		
		return "denied";
	}
	
//	회원가입 선택
	@GetMapping("signup-choice")
	public String signupChoice() {
		
		return "signup-choice";
	}


}
