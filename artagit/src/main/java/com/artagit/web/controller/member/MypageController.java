package com.artagit.web.controller.member;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.artagit.web.entity.Board;
import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;
import com.artagit.web.entity.Comment;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Payment;
import com.artagit.web.entity.Review;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.ExhibitionService;
//import com.artagit.web.service.MyPageService;
import com.artagit.web.service.PaymentService;
import com.artagit.web.service.ReviewService;


@Controller
@RequestMapping("/member/mypage")
public class MypageController {
	
	@Autowired 
	private ExhibitionService exhService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PaymentService payService;
	
	@Autowired
	private ReviewService reviewService;
	
	//@Autowired
	//private PaymentService paymentService;
	
	/*-----------예매내역리스트------*/ 
	@GetMapping("/review/list")
	public String list(Model model,@AuthenticationPrincipal ArtagitUserDetails user) {
		
		System.out.println("1. user==========="+user);
		List<BookingList> bookingList = bookingService.getListById(user.getId());
		int countOfBooking = bookingList.size();
		
		for(int i=0;i<countOfBooking;i++) {
			if(bookingList.get(i).getPayMethod()==null)
				bookingList.get(i).setPayMethod("미결제");
			else
				bookingList.get(i).setPayMethod("결제완료");		
		}

		model.addAttribute("bookingList",bookingList);
		model.addAttribute("countOfBooking",countOfBooking);
		return "member/mypage/booking-list";
		
	}
	
	
	/*-----------리뷰보기------*/ 
	//url에 들어갈 id는 booking
	@GetMapping("/review/{id}")
	public String detail(@PathVariable("id")int id, Model model,@AuthenticationPrincipal ArtagitUserDetails user){

		BookingList booking = bookingService.getReviewByBookingId(id);
		Payment payment = payService.findByBookingId(booking.getBookingId());
		int payId = payment.getId();

		Review review = reviewService.get(payId);
		model.addAttribute("booking",booking);
		model.addAttribute("review",review);
		model.addAttribute("bookingId",booking.getBookingId());
		System.out.println("2. user==========="+user);
		return "member/mypage/review-detail";
	}
	/*-----------리뷰수정------*/
	@GetMapping("/review/update/{id}")
	public String update(@PathVariable("id") int id,@AuthenticationPrincipal ArtagitUserDetails user,Review review) {
		System.out.println("~~~~~~~~~~~~~~~");
//		int result = reviewService.update()
		//int result = reviewService.del(id);
		return "member/mypage/revie-update";
	}
	
	
	/*-----------리뷰삭제------*/ 
	@GetMapping("/review/del/{id}")
	public String delete(@PathVariable("id") int id,@AuthenticationPrincipal ArtagitUserDetails user) {
		int result = reviewService.del(id);
		return "redirect:/member/mypage/review/list";
	}

}
