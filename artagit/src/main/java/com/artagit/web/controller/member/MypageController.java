package com.artagit.web.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
@RequestMapping("/mypage")
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
	public String list(Model model) {
		
		int memId =58;
		List<BookingList> bookingList = bookingService.getListById(memId);
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
	public String detail(@PathVariable("id")int id, Model model){
		//id= book
//		System.out.println("1 리뷰리스트창 들어옴!!");
		BookingList booking = bookingService.getReviewByBookingId(id);
//		System.out.println(booking);
		Payment payment = payService.findByBookingId(booking.getBookingId());
		int payId = payment.getId();
		
		//지금이렇게!!!!!!!
		Review review = reviewService.get(payId);
		System.out.println("상세페이지");
		model.addAttribute("booking",booking);
		model.addAttribute("review",review);
		model.addAttribute("bookingId",booking.getBookingId());
		//System.out.println(booking.getBookingId());
//		System.out.println("1. booking아이디 : "+booking);
//		System.out.println("1 . review-------- : "+review);

		return "member/mypage/review-detail";
	}
	
	
	/*-----------리뷰삭제------*/ 
	
	@GetMapping("/review/del/{id}")
	public String delete(@PathVariable("id") int id) {
		System.out.println("삭제 들옴!!");
		System.out.println(id);
		int result = reviewService.del(id);
		System.out.println(result);
		return "member/mypage/booking-list";
		
	}

}
