package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.service.ExhibitionService;

@RestController
@RequestMapping("/api/")
public class ExhibitionApi {
	
	@Autowired
	private ExhibitionService service;
	
	@GetMapping("lists")
	public List<Exhibition> list(
			@RequestParam(defaultValue = "1", name = "p") int page,
			@RequestParam("m") int museum, 
			@RequestParam("s") int state,
			@RequestParam("c") int category){

		
		List<Exhibition> list = service.getListByCategory(page, museum, state, category);
		
		return list;
	}
	
	@PutMapping("like/{id}")
	public Map<String, Object> likeUp(
			@PathVariable("id") int exhId){
		
		int memId = 1;
		
		int result = service.likeUp(exhId, memId);
		int count = service.countOfLike(exhId);
		Map<String, Object> dto = new HashMap<>();
		//HTTP 가 가지고있는 기본 상태값
		dto.put("status", 200);
		dto.put("resultObject", result);
		dto.put("countNum", count);
		
		return dto;
	}
	
	
	
	@DeleteMapping("like/{id}")
	public Map<String, Object> likeDelete(
			@PathVariable("id") int exhId){
		
		int memId = 1;
		
		int result = service.likeDelete(exhId, memId);
		int count = service.countOfLike(exhId);
		Map<String, Object> dto = new HashMap<>();
		//HTTP 가 가지고있는 기본 상태값
		dto.put("status", 200);
		dto.put("resultObject", result);
		dto.put("countNum", count);
		
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
