package com.artagit.web.controller.api;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.BookingList;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.ExhibitionView;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhibitionService;

@RestController
@RequestMapping("/corpApi")
public class CorporateApi {

	@Autowired
	private CorporateService corpService;
	@Autowired
	private ExhibitionService exhService;
	// 회원 아이디 중복 체크
	@GetMapping("signup/id-check/{value}")
	public Map<String, Object> chkId(@PathVariable ("value") String loginId) {
		int result = corpService.chkId(loginId);
		System.out.println(loginId);
		System.out.println(result);
		Map<String,Object> dto = new HashMap<>();
		dto.put("status", 200);
		dto.put("resultObject",result);
	
		return dto;
	}
	
	@GetMapping("/exh/list")
	public List<Exhibition> list(Model model,
			@AuthenticationPrincipal ArtagitUserDetails user,
			@RequestParam(defaultValue = "1", name = "p") int page) throws ParseException {
				
//		Map<String,Object> dto = new HashMap<>();
		System.out.println("page"+page);
		//ex) 2페이지이면 limit 6,6 개 보내기 
		List<Exhibition> list = exhService.getListById(user.getId(),page);
		System.out.println(list+"----------------exhList");
		
		return list;
	}
	
	@GetMapping("/exh/list/date")
	public List<Exhibition> date(
			@RequestParam(defaultValue = "1", name = "p") int page, 
			@RequestParam("s") int state
			, @AuthenticationPrincipal ArtagitUserDetails user) throws InterruptedException{
		System.out.println("페이지컨트롤"+page);
		//int size = 0;
		List<Exhibition> lists = corpService.getListByDateId(page,state,user.getId());
		System.out.println("상태"+state);
		return lists;
	}
}
