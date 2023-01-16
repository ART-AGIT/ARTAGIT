package com.artagit.web.controller.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Booking;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.ExhibitionView;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Payment;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.MemberService;
import com.artagit.web.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
//@RequestMapping("/corporator/mypage/")
@RequestMapping("/member/exh")

public class ExhibitionController {
	
	@Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
	private ExhibitionService service;
	
	@Autowired
	private CorporateService corporateService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PaymentService payService;
	
//   /********************** 전시등록 시작 **********************/
//	@GetMapping("exh-reg")
//	// 전시 등록 페이지를 불러오는 메서드
//	public String exhReg(Exhibition exhibition) {
//		
//		// return => templates/corporator/mypage/exh-reg.html
//		return "corporator/mypage/exh-reg";
//	}
//	
//	@PostMapping("exh-reg") // form 양식에 입력한 값들을 exh-reg.html 로 보낸다.
//	// 입력한 정보를 받아 DB에 등록하는 메서드
//	public String reg(Exhibition exhibition){
//		System.out.println("등록한 전시 ===> "+ exhibition);
//		
//		// form 에 입력한 값들이 exhibition 객체로 생성된다.
//	    service.reg(exhibition);
//	    
//	    return "redirect:exh-reg";
//	}
//   /********************** 전시등록 끝 **********************/
	
   /********************** 전시 결제선택 **********************/
//	@GetMapping("pay")
//	public String getPayment() {
//
//		return "member/exhibition/pay";
//	}
	
   /********************** 전시 예매 = 전시/사용자 정보 가져오기 **********************/
	@GetMapping("booking/{id}")
	public String get(
			@PathVariable("id") int exhId,
			@AuthenticationPrincipal ArtagitUserDetails user,
			Member member,
			Model model) {
		
		int memberId;
		if(user == null)
			memberId = 0;
		else
			memberId = user.getId();
		
		System.out.println(user);
		ExhibitionView exh = service.getExhById(exhId, user.getId());
		System.out.println(exh);
		model.addAttribute("exh", exh);
		Corporate corp = corporateService.getCorpById(exh.getCorpId());
		model.addAttribute("corp", corp);
		Member mem = memberService.get(memberId);
		model.addAttribute("mem", mem);
//		model.addAttribute("user", user);
		
		return "member/exhibition/booking-ticket";
	}
	/********************** 전시 예매 = 예매정보 insert 하기 **********************/
	/********************** 전시 결제 = 결제정보 insert 하기 
	 * @throws IllegalArgumentException 
	 * @throws JsonProcessingException **********************/
	@PostMapping("pay")
	public void pay(@RequestBody ObjectNode payInfo) throws JsonProcessingException, IllegalArgumentException {

		
		// ObjectMapper = json 형태의 데이터를 java Object 로 변환해주는 클래스 (json 라이브러리 Jackson)
		ObjectMapper mapper = new ObjectMapper();
		
		// 클라이언트에서 넘어온 json의 키값을 가지고 클래스 정보를 얻어 자동으로 매핑을 해준다,
		Booking booking = mapper.treeToValue(payInfo.get("booking"), Booking.class);
		Payment payment = mapper.treeToValue(payInfo.get("payment"), Payment.class);
		
		// bookId를 구하기 위해 booking 먼저 update 해준다.
		System.out.println("예매 정보 ==> " + booking);
		bookingService.add(booking);

		// payment에 bookId를 set해준다.
		System.out.print("결제 정보 ==> " + payment);
		payment.setBookId(bookingService.getBookIdBypayNum(booking.getPayNum()));
		System.out.println("booking===> "+ bookingService.getBookIdBypayNum(booking.getPayNum()));
		payService.add(payment);
		
		System.out.println("결제 성공");
		
	}
	
	

	

}