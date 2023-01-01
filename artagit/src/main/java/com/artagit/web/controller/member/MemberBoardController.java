package com.artagit.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.Notice;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.NoticeService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Controller
@RequestMapping("/member/board/")
public class MemberBoardController {

	@Autowired
	private BoardService service;
	
	
	
	@Autowired
	private NoticeService noticeService;

	/************게시글 디테일*************/
	@GetMapping("{id}")
	public String detail(
		
		@PathVariable("id")int id,
		Model model){
		Board board = service.get(id);
		model.addAttribute("board",board);
		
		
		System.out.println("id:"+ id);
		
		
		return "member/board/detail";
			
		}
	
	/***********게시글 등록 시작****************/
	@GetMapping("reg")
	public String boardReg() {
	
		return "member/board/reg";
	}
	
	@PostMapping("reg")
	public String reg(Board board) {
		
	
		System.out.println("등록한 글 ===> "+board);
		service.reg(board);
		
		return "redirect:list";
	}
	/*******게시글 등록 끝*****************/
		

	
	
}
