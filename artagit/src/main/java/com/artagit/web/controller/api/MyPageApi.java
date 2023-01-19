package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Payment;
import com.artagit.web.entity.Review;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.PaymentService;
import com.artagit.web.service.ReviewService;

@RestController
@RequestMapping("/member/mypage")
public class MyPageApi {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ExhibitionService exhService;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private BoardService boardService;
	
	/*-----------리뷰등록------*/ 
	@PostMapping("/review/reg/{id}")
	@Transactional
	public Map<String,Object> reg(Review review,Booking booking,@PathVariable("id") int payId
			,@AuthenticationPrincipal ArtagitUserDetails user){
		
		System.out.println("들옴ㅇㅇㅇㅇ");
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
	

	
	
	/*-----------모달로 리뷰보기------*/ 
//	@PostMapping("/review/see/{id}")
//	@Transactional
//	public Map<String,Object> see(Booking booking,@PathVariable("id") int reviewId
//			,@AuthenticationPrincipal ArtagitUserDetails user){
//		
//		System.out.println("들옴들옴");
//		System.out.println(reviewId);
//		Review review = reviewService.getbyId(reviewId);
//		System.out.println(review);
////		BookingList booking2 = bookingService.getReviewByBookingId(payId);
////		review.setPayId(payId);
////		review.setColor(review.getColor());
////		Review result = reviewService.reg(review);
//
//		Map<String,Object> dto = new HashMap<>();
////		dto.put("status", 200);
////		dto.put("resultObject",result);
////		dto.put("booking2",booking2);
//		dto.put("review",review);
//
//		return dto;
//	}
	

	/*-----------리뷰수정------*/ 

	@PostMapping("/review/update/{id}")
	@Transactional
	public Map<String,Object> update(Review review,Booking booking,@PathVariable("id") int reviewId
			,@AuthenticationPrincipal ArtagitUserDetails user){
		
		System.out.println("color"+review.getColor());
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
	
	
	
	/*-----------모달로 결제상세------*/ 
	@GetMapping("/payment/{id}")
	@Transactional
	public Map<String,Object> see(@PathVariable("id") int payId
			,@AuthenticationPrincipal ArtagitUserDetails user){
		
		Map<String,Object> dto = new HashMap<>();
		Payment payment = paymentService.get(payId);
		Booking booking = bookingService.get(payId);

		int exhId = bookingService.getExhId(payId);
		Exhibition exh = exhService.getExhById(exhId);
		
		dto.put("booking",booking);
		dto.put("payment",payment);
		dto.put("user",user);
		dto.put("exhibition",exh);
		
		return dto;
	}
	
	
	
	
	
	
	
	
	

//	/******좋아요한 게시글***********/
//	@GetMapping("/post-like")
//	public List<BoardListView> getListByCategory(
//			@AuthenticationPrincipal ArtagitUserDetails user) {
//		int memId = user.getId();
//		List<BoardListView> list = boardService.getLikeList(memId);
//		System.out.println("++++++++++=" + list);
//		return list;
//	}


	
}