package com.artagit.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.Booking;
import com.artagit.web.entity.BookingList;
import com.artagit.web.entity.Comment;
import com.artagit.web.entity.Exhibition;
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
	@GetMapping("/review/{id}")
	public String detail(@PathVariable("id")int id, Model model){
		
		BookingList booking = bookingService.getReviewByBookingId(id);
		Review review = reviewService.get(id);
//		System.out.println(review);
		model.addAttribute("booking",booking);
		model.addAttribute("review",review);
		return "member/mypage/review-detail";
	}
	
	/*-----------리뷰작성------*/ 
	@PostMapping("/review/reg")
	public String reg(@RequestParam ("review-id") int reviewId , String content){
		Review review = reviewService.get(reviewId);
		System.out.println(review);
		System.out.println(content);
//		reviewService.reg()
		return "";
	}
	
	/*-----------리뷰삭제------*/
//	@PostMapping("/review/{id}/delete")
//	public String delete(@PathVariable("id")int id, Model model){
//		
//		return "";
//	}
}
