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
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.Booking;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Local;
import com.artagit.web.entity.PayList;
import com.artagit.web.entity.Payment;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.LocalService;
import com.artagit.web.service.PaymentService;

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
	@ResponseBody
	@GetMapping("update")
	public void update(@RequestParam("id") int id,
			@RequestParam("name") String name) {
//		System.out.println("수정한 전시 ===> "+ id);
//		id = 19;
		service.update(id, name);
		System.out.println("수정완료");
	}
	
	// 주최자가 등록한 전시 삭제 ========================
	@GetMapping("delete")
	public String delete(int id) {
//		@PathVariable("exhId")
		service.delete(id);
		
		System.out.println("주최자 등록한 전시(id==>"+ id +") 삭제(useYn = N)완료");
		 return "redirect:list";
	}
}
