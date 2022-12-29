package com.artagit.web.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.Booking;
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
		//필요한정보테이블 : payment, booking, Exhibition,  
		//List<Exhibition> exhList = exhService.getListById(memId);
		
		List<Exhibition> exhList;
		List<Booking> bookList = bookingService.getListById(memId);
		int count = bookList.size();
		System.out.println(count);
		exhList = exhService.getListtt(memId);
		System.out.println(exhList);
		//for(int i=0;i<count;i++) { 
			
//			select * from Exhibition
//			join Booking 
//			on Exhibition.id = Booking.exhId
//			where Booking.memId = 58;
		//}
			
		//System.out.println(bookList.get(0).getDate());
		model.addAttribute("exhList",exhList);
		model.addAttribute("bookList",bookList);
		return "member/mypage/booking-list";
		
	}
	
	/*-----------예매내역상세------*/ 
	@GetMapping("{id}")
	public String detail(
			
			@PathVariable("id")int id,Model model){
//			Board board = service.get(id);
			Review review = reviewService.get(id);


		return "member/mypage/review-detail";
	}
}
	/*th:href="@{{id}(id=${board.id})}"
	 */
	
	/*
	@PostMapping("/review/reg")
	public String reg() {
		int memId = 58;
		myPageService.reg(memId);
		return null;
	}
	*/
	
	
	
	
//	//리뷰등록
//	@PostMapping("/review/reg")
//	public String list() {
//		
//		
//		return null;
//		
//	}
