package com.artagit.web.controller;

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

import com.artagit.web.entity.Notice;
import com.artagit.web.service.NoticeService;

@Controller
@RequestMapping("/")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	public NoticeController() {

	}
	
	public NoticeController(NoticeService service) {
		this.service = service;
	}
	
	/********************** 공지사항 목록 조회 시작 **********************/
//	@GetMapping("notice/list")
	@GetMapping("customer_notice")
	public String list(
			@RequestParam(defaultValue = "1", name="p") int page,
			Model model) {
		
		int size = 6;
		int offset = (page-1)*size;
		
		List<Notice> list = service.getList(page);
		model.addAttribute("list", list);
		
		return "customer-center";
	}
	
	// 공지 상세내용 불러오기
	@GetMapping("customer_notice/{id}")
	@ResponseBody
	public Notice detail(
			@PathVariable("id") int id,
			Model model) {
		
		Notice notice = service.getNoticeById(id);
		model.addAttribute("notice", notice);
			return notice;
	}
	
}
