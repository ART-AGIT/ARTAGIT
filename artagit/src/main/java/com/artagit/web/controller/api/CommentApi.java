package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Comment;
import com.artagit.web.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentApi {

	@Autowired
	private CommentService service;

	@PostMapping("reg")
	public Map<String, Object> reg(Comment comment, @AuthenticationPrincipal ArtagitUserDetails user) {

		Map<String, Object> dto = new HashMap<>();
		Map<String, Object> list = service.write(comment);

		dto.put("status", 200);
		dto.put("member", list.get("member"));
		dto.put("comment", list.get("comment"));
		
		return dto;
	}

	@PutMapping("update")
	public Map<String, Object> update(Comment comment,@AuthenticationPrincipal ArtagitUserDetails user) {
		System.out.println(comment);
		Map<String, Object> dto = new HashMap<>();
		Map<String, Object> list = service.modify(comment);
		dto.put("status", 200);
		dto.put("members", list.get("member"));
		dto.put("comments", list.get("comment"));
		System.out.println(dto);
		return dto;

	}
	
	
//	@PutMapping("update")
//	public Comment update(Comment comment, @AuthenticationPrincipal ArtagitUserDetails user) {
//		int id = 3;
//	Comment	result = service.modifyTest(comment, id);
//		return result;
//	}
//	
	
	
}
