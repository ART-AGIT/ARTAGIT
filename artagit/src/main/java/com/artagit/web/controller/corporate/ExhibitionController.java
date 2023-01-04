package com.artagit.web.controller.corporate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Local;
import com.artagit.web.entity.PayList;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.LocalService;
import com.artagit.web.service.MuseumService;
import com.artagit.web.service.PaymentService;

@Controller("corporaterController")
@RequestMapping("corp/exh/")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService service;
	
	@Autowired
	private CorporateService corporateService;
	
	@Autowired
	private MuseumService museumService;
	
	@Autowired
	private LocalService localService;
	
//	@Autowired
//	private BookingService bookingService;

//	@Autowired
//	private PaymentService paymentService;
	
	@Autowired
	private PaymentService payListService;
	
	//나의 등록전시
	@GetMapping("list")
	public String list(Model model) {
			//@RequestParam(name="memId")int memId,Model model) {
		int memId=1;
		List<Exhibition> list = service.getListById(memId);
		
		int countOfExh = service.countOfExh(memId);
		model.addAttribute("list",list);
//		System.out.println(countOfExh);
		model.addAttribute("countOfExh",countOfExh);
//		System.out.println(list);
		return "corporator/mypage/exh-list";
	}
	
	
	// 주최자가 등록한 전시 상세 ========================
	@GetMapping("{id}")
	public String detail(
			@PathVariable("id") int exhId,
			Model model) {
		// 전시 상세 내용
		Exhibition exh = service.getExhById(exhId);
		model.addAttribute("exh",exh);
		Corporate corporate = corporateService.getCorpById(exh.getCorpId());
		model.addAttribute("corporate",corporate);
		Local local = localService.getLocalById(corporate.getLocalId());
		model.addAttribute("local",local);
		
		// ** 결제 내역
		List<PayList> payList = payListService.getPayListById(exhId);
		model.addAttribute("payList",payList);
		
		
		return "corporator/mypage/exh-detail";
	}

	// 주최자가 등록한 전시 수정 ========================
	@GetMapping("update")
	public String update(Exhibition exhibition, Corporate corporate) {
//		System.out.println("수정한 전시 ===> "+ id);
		service.update(exhibition.getId());
//		corporateService.update(id);
//		museumService.update(id);
//		System.out.println(id+"번 전시 수정완료");
		
		return "redirect:corp/exh/{id}";
	}
	
	// 주최자가 등록한 전시 삭제 ========================
	@GetMapping("delete")
	public String delete(int id) {
//		@PathVariable("exhId")
		service.delete(id);
		
		System.out.println("주최자 등록한 전시(id==>"+ id +") 삭제(useYn = N)완료");
		 return "redirect:list";
	}
	
	//전시등록하기
	@GetMapping("reg")
	public String reg(Model model, @AuthenticationPrincipal ArtagitUserDetails user) {

		System.out.println(user);
		model.addAttribute("user",user);
		
		return "corporator/mypage/exh-reg";
	}
	// 주최자가 전시 등록하기 insert==========================
	@PostMapping("insert") 
	public String insert(Exhibition exhibition){
		
		System.out.print("전시 :" +exhibition.toString());
		//service.insert(exhibition);

		//int result = 0;
		// result =
		
		
//		try {
//		}
//		catch(Exception e) {
//			result = -1;
//		}
//		
//		if(result >0 ) {
//			//log
//		}else if(result == 0) {
//		
//		}else if( result == -1) {
//		 
//		}else {
//			
//		}
		return "redirect:list";
	}
		
		
//	// 주최자가 등록한 전시 삭제 ========================
//	@GetMapping("delete")
//	public String delete(int id) {
////		@PathVariable("exhId")
//		service.delete(id);
//		
//		System.out.println("주최자 등록한 전시(id==>"+ id +") 삭제(useYn = N)완료");
//		 return "redirect:list";
//	}
}
