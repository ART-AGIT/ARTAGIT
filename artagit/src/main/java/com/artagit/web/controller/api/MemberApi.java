package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.service.MemberService;

@RestController
@RequestMapping("/userApi")
public class MemberApi {
	@Autowired
	private MemberService service;
	
	// 회원 아이디 중복 체크
	@GetMapping("signup/id-check/{value}")
	public Map<String, Object> chkId(@PathVariable ("value") String loginId) {
		int result = service.chkId(loginId);
		System.out.println(loginId);
		System.out.println(result);
		Map<String,Object> dto = new HashMap<>();
		dto.put("status", 200);
		dto.put("resultObject",result);
	
		return dto;
	}
	
	
	
	
	
}
