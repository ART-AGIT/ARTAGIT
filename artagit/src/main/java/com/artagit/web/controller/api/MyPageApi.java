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
		
		BookingList booking2 = bookingService.getReviewByBookingId(payId);
		review.setPayId(payId);
		review.setColor(review.getColor());
		Review result = reviewService.reg(review);

		Map<String,Object> dto = new HashMap<>();
		dto.put("status", 200);
		dto.put("resultObject",result);
		dto.put("booking2",booking2);

		return dto;
	}
	
	/*-----------리뷰수정------*/ 

	@PostMapping("/review/update/{id}")
	@Transactional
	public Map<String,Object> update(Review review,Booking booking,@PathVariable("id") int reviewId
			,@AuthenticationPrincipal ArtagitUserDetails user){



		review.setColor(review.getColor());
		System.out.println("review2---"+review);
		Review result = reviewService.update(review);
		System.out.println("result"+result);
		
		
		int payId = result.getPayId();
		System.out.println(payId);
		BookingList bookingList = bookingService.getReviewByBookingId(payId);
		System.out.println(bookingList);
		
		
		
		
		Map<String,Object> dto = new HashMap<>();
		dto.put("status", 200);
		dto.put("resultObject",result);
		dto.put("bookingList",bookingList);

		return dto;
	}
	
	
}