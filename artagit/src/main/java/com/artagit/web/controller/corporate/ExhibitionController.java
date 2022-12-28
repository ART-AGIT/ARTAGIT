package com.artagit.web.controller.corporate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Local;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.LocalService;

@Controller("corporaterController")
@RequestMapping("corp/exh/")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService service;
	
	@Autowired
	private CorporateService corporateService;
	
	@Autowired
	private LocalService localService;
	
//	@Autowired
//	private BookingService bookingService;
	
//	@Autowired
//	private PaymentService paymentService;
	
	//나의 등록전시
	@GetMapping("list")
	public String list(Model model) {
			//@RequestParam(name="memId")int memId,Model model) {
		int memId=1;
		List<Exhibition> list = service.getListById(memId);
		
		int countOfExh = service.countOfExh(memId);
		model.addAttribute("list",list);
		System.out.println(countOfExh);
		model.addAttribute("countOfExh",countOfExh);
		System.out.println(list);
		return "corporator/mypage/exh-list";
	}
	
	
	// 주최자가 등록한 전시 상세 목록 ========================
	@GetMapping("{id}")
	public String detail(
			@PathVariable("id") int exhId,
			Model model) {
		// 전시의 id로 coprId를 가져와 
		// corp정보 모두 가져오기
		Exhibition exh = service.getExhById(exhId);
		model.addAttribute("exh",exh);
		Corporate corporate = corporateService.getCorpById(exh.getCorpId());
		model.addAttribute("corporate",corporate);
		// corp정도에서 coprLocalId를 통해 Local 테이블의 name가져오기
		Local local = localService.getLocalById(corporate.getLocalId());
		model.addAttribute("local",local);
		
		// ** 결제 내역
		
		
		
		return "corporator/mypage/exh-detail";
	}
	
	
//	public String detail(
//			@RequestParam("id") int id,
//			Model model){
//		
//		
//	}
	
	
}
