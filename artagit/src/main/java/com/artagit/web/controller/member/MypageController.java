package com.artagit.web.controller.member;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.BookingList;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Payment;
import com.artagit.web.entity.Review;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.MemberService;
//import com.artagit.web.service.MyPageService;
import com.artagit.web.service.PaymentService;
import com.artagit.web.service.ReviewService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;


@Controller
@RequestMapping("/member/mypage")
public class MypageController {
	
	@Autowired 
	private ExhibitionService exhService;
	
	@Autowired

	private BookingService bookingService;
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Autowired
//	private MyPageService myPageService;
	
	@Autowired
	private PaymentService payService;
	
	@Autowired
	private ReviewService reviewService;
	
	//@Autowired
	//private PaymentService paymentService;
	
	@Autowired
	private BoardService boardService;
	
	/*-----------예매내역리스트------*/ 
	@GetMapping("/review/list")
	public String list(Model model,@AuthenticationPrincipal ArtagitUserDetails user) {
		
		System.out.println("1. user==========="+user);
		List<BookingList> bookingList = bookingService.getListById(user.getId());
		int countOfBooking = bookingList.size();
//		System.out.println("----"+bookingList.get(0).getImage());
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
	//bookingId = payId 
	@GetMapping("/review/{id}")
	public String detail(@PathVariable("id")int id, Model model,@AuthenticationPrincipal ArtagitUserDetails user){

		BookingList booking = bookingService.getReviewByBookingId(id);
		Payment payment = payService.findByBookingId(booking.getBookingId());
		int payId = payment.getId();

		Review review = reviewService.get(payId);
		model.addAttribute("booking",booking);
		model.addAttribute("review",review);
		model.addAttribute("bookingId",booking.getBookingId());
//		System.out.println("2. user==========="+user);
		
		return "member/mypage/review-detail";
	}
	
	/*-----------리뷰수정------*/
	@GetMapping("/review/update/{id}")
	public String update(@PathVariable("id") int id,@AuthenticationPrincipal ArtagitUserDetails user,Model model) {
		System.out.println("여기들옴");

		System.out.println(id);
		Review review = reviewService.getbyId(id);
		model.addAttribute("review",review);
		System.out.println(review.getPayId());
		int payId = review.getPayId();
		model.addAttribute("payId",payId);
		BookingList booking = bookingService.getReviewByBookingId(payId);
		model.addAttribute("booking",booking);
		System.out.println(booking);
		
		return "member/mypage/review-update";
	}
	
	
	/*-----------리뷰삭제------*/ 
	@GetMapping("/review/del/{id}")
	public String delete(@PathVariable("id") int id,@AuthenticationPrincipal ArtagitUserDetails user) {
		int result = reviewService.del(id);
		return "redirect:/member/mypage/review/list";
	}


//===================회원수정===================
	@GetMapping("/account-edit/{id}")
	public String update(@AuthenticationPrincipal ArtagitUserDetails user, Model model, Member member) {
		//회원수정페이지불러올때 회원가입할때정보불러오기 user쓰기

		model.addAttribute("user",user);
		//System.out.println(user.getPhone());
		//memberService.update(user);
		
		
		return "member/mypage/account-edit";
	}
	
	@PostMapping("/account-edit")
	public String modify(@AuthenticationPrincipal ArtagitUserDetails user, Model model, Member member) {
		
//		
//		System.out.println("user"+user);
//		System.out.println("member"+member);
		
		String password = member.getPassword();
		String encPassword = passwordEncoder.encode(password);
		
		member.setPassword(encPassword);
		System.out.println(encPassword);
		System.out.println(member);
		//member.setPassword(member.getPassword()); 
		memberService.update(member);
		
		user.setNickname(member.getNickname());
		user.setUsername(member.getLoginId());
		user.setName(member.getName());
		user.setEmail(member.getEmail());
		user.setPhone(member.getPhone());
		
		model.addAttribute("user",user);

//		System.out.println("member"+memb);
		
		
		
		return "member/mypage/account-edit";
	}

	@GetMapping("like-list")
	public String likeList(@AuthenticationPrincipal ArtagitUserDetails user) {
		List<BoardListView> list = boardService.getLikeList(user.getId());
		return "member/mypage/like-list";
	}
	
	/********내가 쓴 게시글 리스트 불러오기*******/
//	@GetMapping("/post-list")
//	public String post(Model model,@AuthenticationPrincipal ArtagitUserDetails user) {
//		List<BoardListView> list = boardService.getListById(user.getId());
//		model.addAttribute("list",list);
//		
//		System.out.println("로그인한 아이디가 쓴 글====>"+model);
//		return "member/mypage/post-list";
//		
//	}

}