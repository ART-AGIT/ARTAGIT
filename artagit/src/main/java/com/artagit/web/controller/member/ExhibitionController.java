package com.artagit.web.controller.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("exh", exh);
		
		Corporate corp = corporateService.getCorpById(exh.getCorpId());
		model.addAttribute("corp", corp);
		
		Member mem = memberService.get(memberId);
		model.addAttribute("mem", mem);
		
		System.out.println("주문번호: "+service.getPayNum());
		
		return "member/exhibition/booking-ticket";
	}
	/********************** 전시 예매 = 예매정보 insert 하기 **********************/
	/********************** 전시 결제 = 결제정보 insert 하기 
	 * @throws IllegalArgumentException 
	 * @throws JsonProcessingException **********************/
	@Transactional
	@PostMapping("pay")
	public void pay(@RequestBody ObjectNode payInfo)  {
		System.out.println("pay 메서드 진입");
		
		// ObjectMapper = json 형태의 데이터를 java Object 로 변환해주는 클래스 (json 라이브러리인 Jackson의 ObjectMapper 이용)
		ObjectMapper mapper = new ObjectMapper();
		
		// 클라이언트에서 넘어온 json의 키값을 가지고 클래스 정보를 얻어 자동으로 매핑을 해준다.
		// treeToValue는 JsonProcessingException을 내기 때문에 이에 대한 예외처리를 꼭 해줘야한다.
		// JsonProcessingException은 IOException의 하위 클래스이다. 즉, checked Exception 이고, 컴파일 시 예외를 검사하므로
		// 반드시 예외처리를 해주어야 하기때문에 try / catch로 묶어주었다. 
		
		Booking booking = null; // 예외 처리를 하니까 왜 Booking booking = mapper.treeToValue 에서 Booking booking; 을 분리해버리는거지?
		Payment payment = null;
		
		try {
			booking = mapper.treeToValue(payInfo.get("booking"), Booking.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			System.out.println("JsonProcessingException. Ex:" + e.getMessage() + ", booking: " + booking);
		} catch (IllegalArgumentException e) { // 객체 반환 시 json 으로 변환이 되지 않는 경우
			e.printStackTrace();
		}

		try {
			payment = mapper.treeToValue(payInfo.get("payment"), Payment.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			// bookId를 구하기 위해 booking 먼저 update 해준다.
			System.out.println("예매 정보 ==> " + booking);
			booking.setPayNum(service.getPayNum());
			bookingService.add(booking);
			
			// payment에 bookId를 set해준다.
			System.out.print("결제 정보 ==> " + payment);
			payment.setPayNum(booking.getPayNum());
			payment.setBookId(bookingService.getBookIdBypayNum(booking.getPayNum()));
			System.out.println("생성된 주문번호: "+ bookingService.getBookIdBypayNum(booking.getPayNum()));
			payService.add(payment);
		}
		
		System.out.println("결제 성공");
	}

}