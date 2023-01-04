package com.artagit.web.controller.corporate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.service.CorporateService;

@ResponseBody
@RequestMapping("/corp")
public class CorporateController {

	@Autowired
	private CorporateService service;
	
	@GetMapping("account-edit")
	public String deleteUseYN() {
		
		return "corporator/mypage/account-edit";
	}
	
	
//	@PostMapping("{id}")
//	public String deleteUseYN(@RequestParam("id") int id){
//		// 되는지 확인용
//		int memid=51;
//		String useYN2 = "Y";
//		service.deleteUseYN(memid,useYN2);
////		
//		return "corporator/mypage/account-edit";
////		return "redirect:/";
//	}
	
}
