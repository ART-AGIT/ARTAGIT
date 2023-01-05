package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;
import com.artagit.web.entity.Review;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.ReviewService;

@RestController
@RequestMapping("/member/mypage")
public class MyPageApi {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private BookingService bookingService;
	
	/*-----------리뷰등록------*/ 
	@PostMapping("/review/reg/{id}")
	@Transactional
	public Map<String,Object> reg(Review review,Booking booking,@PathVariable("id") int payId
			,@AuthenticationPrincipal ArtagitUserDetails user){

		System.out.println("3.user -------"+review.getColor());
//		System.out.println("2 리뷰 등록창 들어옴!!");
		System.out.println("2 . review-------- : "+review);
		BookingList booking2 = bookingService.getReviewByBookingId(payId);
//		System.out.println("2 . booking-------- : "+booking2);
//		Payment payment = payService.findByBookingId(bookId);
//		int payId = payment.getId();

//		System.out.println(review.get);
		
		review.setPayId(payId);
		System.out.println("2 . review-------- : "+review);
		System.out.println(review.getColor().getClass());
		System.out.println(review.getColor());
		review.setColor(review.getColor());
//		System.out.println("payId"+payId);
//		System.out.println("보내야할 review"+review);
		
		Review result = reviewService.reg(review);
//		int result=reviewService.reg(review);
		
//		Review result2 = reviewService.get(payId);
//		System.out.println("Review--------"+review.getPayId());
		System.out.println("결과----"+result);
		Map<String,Object> dto = new HashMap<>();
		dto.put("status", 200);
		dto.put("resultObject",result);
		dto.put("booking2",booking2);
		//dto.put("resultObject",result);
//		System.out.println("==============="+result);
//		System.out.println("=======dto========"+dto);
		return dto;
	}
}
