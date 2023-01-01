package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.Notice;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.NoticeService;

@RestController
@RequestMapping("/api/")
public class BoardApi {

	@Autowired
	private BoardService service;
	@Autowired
	private NoticeService noticeService;
	/*************게시글 리스트 불러오기*********/
	@GetMapping("boards")
	public List<BoardListView> getListByCategory(
			@RequestParam("c") int roleId){
		List<BoardListView> list = service.getListByCategory(roleId);
		System.out.println(roleId);
		return list;
	}
	

		
		
		
}
