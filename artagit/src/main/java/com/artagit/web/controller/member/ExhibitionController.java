package com.artagit.web.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.Exhibition;
import com.artagit.web.service.ExhibitionService;

@Controller
@RequestMapping("/corporator/mypage/")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService service;
	
	public ExhibitionController() {

	}

	public ExhibitionController(ExhibitionService service) {
		this.service = service;
	}

	
	@PostMapping("exh-reg")
	public String create(Exhibition form){
		System.out.println(form);
		
		Exhibition exhibition = form;
		
//		Exhibition exhibition = new Exhibition();	
//	    exhibition.setName(form.getName());
//	    exhibition.setContent(form.getContent());
//	    exhibition.setPoster(form.getPoster());
//	    exhibition.setDetailImage(form.getDetailImage());
//	    exhibition.setStartDate(form.getStartDate());
//	    exhibition.setEndDate(form.getEndDate());
//	    exhibition.setStartTime(form.getStartTime());
//	    exhibition.setEndTime(form.getEndTime());
//	    exhibition.setTicketPrice(form.getTicketPrice());
//	    exhibition.setTicketStock(form.getTicketStock());
//	    exhibition.setArtist(form.getArtist());
//	    exhibition.setCateId(form.getCateId());
//	    exhibition.setMemId(form.getMemId());
//	    exhibition.setStateId(form.getStateId());
//	    exhibition.setMuseumId(form.getMuseumId());
//	    exhibition.setPoster(form.getPoster());
	    
	    
	    service.reg(exhibition);
	    
	    return "index";
	
	}

	@GetMapping("exh-reg")
	public String reg(Exhibition exhibition) {
//		service.reg();
		
		return "corporator/mypage/exh-reg";
	}
	

}
