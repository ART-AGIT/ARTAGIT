package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.ExhLikeList;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.ExhibitionView;
import com.artagit.web.service.ExhLikeService;
import com.artagit.web.service.ExhibitionService;

@RestController
@RequestMapping("/api/")
public class ExhibitionApi {
	
	@Autowired
	private ExhibitionService service;
	
//	@Autowired
//	private ExhLikeService exhLikeService;
	
	@GetMapping("lists")
	public List<ExhibitionView> list(
			@RequestParam(defaultValue = "1", name = "p") int page,
			@RequestParam("l") int local, 
			@RequestParam("s") int state,
			@RequestParam("c") int category
			, @AuthenticationPrincipal ArtagitUserDetails user) throws InterruptedException{
//		Thread.sleep(500);
		int memberId;
		if(user == null)
			memberId = 0;
		else
			memberId = user.getId();
		
		int size = 0;
		List<ExhibitionView> lists = service.getListByMemberId(page,size,local,state,category,memberId);
		
		return lists;
	}
	
	@PutMapping("like/{id}")
	public Map<String, Object> likeUp(
			@PathVariable("id") int exhId
			, @AuthenticationPrincipal ArtagitUserDetails user){
		Map<String, Object> dto = new HashMap<>();
		if(user.getRoleId() == 2) {
			int result = service.likeUp(exhId, user.getId());
			System.out.println("좋아요 성공");
//		int count = service.countOfLike(exhId);
			//HTTP 가 가지고있는 기본 상태값
			dto.put("status", 200);
			dto.put("resultObject", result);
//		dto.put("countNum", count);
		}
		else {
			dto.put("status", 405);
			dto.put("resultObject", 0);
		}
	
		return dto;
	}
	
	
	
	@DeleteMapping("like/{id}")
	public Map<String, Object> likeDelete(
			@PathVariable("id") int exhId,
			@AuthenticationPrincipal ArtagitUserDetails user){

		int result = service.likeDelete(exhId, user.getId());
		int count = service.countOfLike(exhId);
		List<Exhibition> likeList = service.getLikeListByIdAll(user.getId());
		Map<String, Object> dto = new HashMap<>();
		//HTTP 가 가지고있는 기본 상태값
		dto.put("status", 200);
		dto.put("resultObject", result);
		dto.put("countNum", count);
		dto.put("likeList",likeList);
		
		return dto;
	}
	
	// 주최자가 등록한 전시 삭제 ========================
	@DeleteMapping("delete/{id}")
	public Map<String, Object> delete(@PathVariable("id") int id) {
		int result = service.delete(id);
		
		Map<String, Object> dto = new HashMap<>(); // result 객체
		dto.put("status", 200); // http가 갖고 있는 기본 상태값
		dto.put("resultObject", result);
		
		System.out.println("주최자 등록한 전시(id==>"+ id +") 삭제(useYn = N)완료");
		 return dto;
	}

}
