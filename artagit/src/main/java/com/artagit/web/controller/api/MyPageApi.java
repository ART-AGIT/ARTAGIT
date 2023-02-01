package com.artagit.web.controller.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.artagit.web.entity.ExhLikeList;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Payment;
import com.artagit.web.entity.Review;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.ExhLikeService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.MemberService;
import com.artagit.web.service.PaymentService;
import com.artagit.web.service.ReviewService;

@RestController
@RequestMapping("/member/mypage")
public class MyPageApi {
	
	@Autowired
	private MemberService memberService;
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
	
	@Autowired
	private ExhLikeService exhLikeService;
	
	
	/*-----------api 로 예매내역리스트------*/ 
	
	@GetMapping("/review/api/list")
	public List<BookingList> list(Model model,
			@AuthenticationPrincipal ArtagitUserDetails user,
			@RequestParam(defaultValue = "1", name = "p") int page) throws ParseException {
				
//		Map<String,Object> dto = new HashMap<>();
		System.out.println("page"+page);
		//ex) 2페이지이면 limit 6,6 개 보내기 
		List<BookingList> bookingList = bookingService.getListById(user.getId(),page);
//		dto.put("list", bookingList);
		System.out.println(bookingList);
		return bookingList;
	}
	
		// 좋아요 전시 더보기 api
		@GetMapping("/api/like-list")
		public List<ExhLikeList> likeList(@AuthenticationPrincipal ArtagitUserDetails user,
			   					Model model,
			   					@RequestParam(defaultValue = "1", name = "p") int page,
			   					@RequestParam(defaultValue = "0", name = "d")int delCount) {
	      System.out.println("APIIIIIIIpage@@@@@@@@@@@@@@@@"+page);
	      List<ExhLikeList> ehxLikeList = exhLikeService.getLikeListById(user.getId(),page);
	      System.out.println("좋아요한 전시APIIIIIIIIIIIIIIIIII");
	      System.out.println(ehxLikeList);
//	      model.addAttribute("ehxLikeList", ehxLikeList);
//	      
//	      Member member = memberService.get(user.getId());
//	      int countOfExhLike = exhLikeService.getCount(user.getId());
//	      System.out.println(countOfExhLike);
//	      w3e
//	      model.addAttribute(member);
//	      model.addAttribute(countOfExhLike);
//	      model.addAttribute("user",user);
	      return ehxLikeList;
	     
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*-----------리뷰등록------*/ 
	/*
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
	*/
	
	/*-----------모달로 등록된 리뷰띄우기------*/ 
	@GetMapping("/review/api/{reviewId}")
	@Transactional
	public Map<String,Object> view(@PathVariable("reviewId") int id
			,@AuthenticationPrincipal ArtagitUserDetails user){
				
		System.out.println("리뷰모달띄우기에 들옴");
		System.out.println("reviewId "+id);
		
		//리뷰 아이디로 부킹뷰 끌어오기
		BookingList bookingInfo = bookingService.getBookingViewByReviewId(id);
		System.out.println(bookingInfo);
		System.out.println(bookingInfo.getColor());
		Map<String,Object> dto = new HashMap<>();
		dto.put("bookingInfo",bookingInfo);

		return dto;
		
		
	}
	
	/*-----------모달 리뷰 등록시 가져올 정보들------*/ 
	@GetMapping("/review/api/view/{bookingId}")
	@Transactional
	public Map<String,Object> viewInfo(@PathVariable("bookingId") int bookingId
			,@AuthenticationPrincipal ArtagitUserDetails user){
		
		System.out.println("들어왔니?"+bookingId);
		//부킹아이디로 부킹리스트뷰 정보 갖고오기
		BookingList bookingInfo = bookingService.getBookingViewByBookingId(bookingId);
		System.out.println(bookingInfo);
		Map<String,Object> dto = new HashMap<>();
		dto.put("bookingInfo",bookingInfo);
		return dto;
	}
	
	
	/*-----------모달 리뷰 등록------*/ 
	@PostMapping("/review/api/reg/{bookingId}")
	@Transactional
	public Map<String,Object> reg(@PathVariable("bookingId") int bookingId,Review review
			,@AuthenticationPrincipal ArtagitUserDetails user){
		
		System.out.println("들어왔나 등록?"+bookingId);
		System.out.println(review);
		review.setPayId(bookingId);
		System.out.println(review);
		Review result = reviewService.reg(review);
		System.out.println(result);
		int regResult;
		Map<String,Object> dto = new HashMap<>();
	
		if(result != null) {
			regResult=0;
		}
		else {
			regResult=1;
		}
		System.out.println(regResult);
		dto.put("regResult",regResult);
		dto.put("result", result);
		return dto ;
	}
	
	/*-----------모달에서 리뷰 삭제------*/ 
	@DeleteMapping("/review/api/del/{reviewId}")
	@Transactional
	public int del(@PathVariable("reviewId") int reviewId,Review review
			,@AuthenticationPrincipal ArtagitUserDetails user){
		
		int result = reviewService.del(reviewId);
		System.out.println("result"+result);
		return result ;
	}
	
	/*-----------모달에서 리뷰 수정------*/ 
	@PostMapping("/review/api/mod/{reviewId}")
	@Transactional
	public int modify(@PathVariable("reviewId") int reviewId,Review review
			,@AuthenticationPrincipal ArtagitUserDetails user){
		
		System.out.println("변경된컬러"+review.getColor());
		
		review.setId(reviewId);
		review.setColor(review.getColor());
		review.setContent(review.getContent());
		System.out.println("---변경된 리뷰"+review);
		int result = reviewService.update(review);
		
		System.out.println(result);

		
		return result ;
	}

	
	
	
	
	

	/*-----------리뷰수정------*/ 
	/*
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
	
	*/
	
	
	/*-----------모달로 결제상세------*/ 
	@GetMapping("/payment/{id}")
	@Transactional
	public Map<String,Object> see(@PathVariable("id") int payId
			,@AuthenticationPrincipal ArtagitUserDetails user){
		System.out.println("payment api안에 들어옴");
		Map<String,Object> dto = new HashMap<>();
		Payment payment = paymentService.get(payId);
		Booking booking = bookingService.get(payId);
		System.out.println("booking"+booking);
		int exhId = bookingService.getExhId(payId);
		Exhibition exh = exhService.getExhById(exhId);
		
		dto.put("booking",booking);
		dto.put("payment",payment);
		dto.put("user",user);
		dto.put("exhibition",exh);
		
		return dto;
	}
	
	
	
	
	
	

	/******좋아요한 게시글***********/
	@GetMapping("/board/api/list")
	public List<BoardListView> boardList(Model model,
			@AuthenticationPrincipal ArtagitUserDetails user,
			@RequestParam(defaultValue = "1", name = "p") int page) throws ParseException {
				
//		Map<String,Object> dto = new HashMap<>();
		System.out.println("page"+page);
		//ex) 2페이지이면 limit 6,6 개 보내기 
		List<BoardListView> list = boardService.getListById(user.getId(),page);
//		dto.put("list", bookingList);
		
		System.out.println(list);
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}