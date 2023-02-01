package com.artagit.web.controller.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.BookingList;
import com.artagit.web.entity.ExhLike;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Member;
import com.artagit.web.entity.Payment;
import com.artagit.web.entity.Review;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.BookingService;
import com.artagit.web.service.ExhLikeService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.MemberService;
//import com.artagit.web.service.MyPageService;
import com.artagit.web.service.PaymentService;
import com.artagit.web.service.ReviewService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member/mypage")
public class MypageController {

	@Autowired
	private ExhibitionService exhService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private PaymentService payService;

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ExhLikeService exhLikeService;
	
	//@Autowired
	//private PaymentService paymentService;
	
	@Autowired
	private BoardService boardService;

	/*-----------예매내역리스트------*/
	// 결제상세 모달 정보 : Payment(결제번호 결제날짜 ) User(아이디

	@GetMapping("/review/list")
	public String list(Model model, @AuthenticationPrincipal ArtagitUserDetails user,
			@RequestParam(defaultValue = "1", name = "p") int page) throws ParseException {

		System.out.println("page" + page);
		String todayfm = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date(dateFormat.parse(todayfm).getTime());

		List<BookingList> bookingList = bookingService.getListById(user.getId(), page);

		int countOfBooking = bookingService.getCount(user.getId());
		int temp;
		if (countOfBooking < 6)
			temp = countOfBooking;
		else
			temp = 6;

		System.out.println(temp);
		for (int i = 0; i < temp; i++) {
			Date date = bookingList.get(i).getBookingDate();
			int compare = today.compareTo(date);

			if (compare > 0) // today>date
				bookingList.get(i).setPayMethod("관람 완료");
			else
				bookingList.get(i).setPayMethod("미관람");
//				
		}
		System.out.println();
		System.out.println("user정보~~~~"+user);
		model.addAttribute("user", user);
		model.addAttribute("bookingList", bookingList);
		model.addAttribute("countOfBooking", countOfBooking);
		return "member/mypage/booking-list";

	}

	/*-----------리뷰보기------*/
	// url에 들어갈 id는 booking
	// bookingId = payId
	/*
	 * @GetMapping("/review/{id}") public String detail(@PathVariable("id")int id,
	 * Model model,@AuthenticationPrincipal ArtagitUserDetails user){
	 * 
	 * BookingList booking = bookingService.getReviewByBookingId(id); Payment
	 * payment = payService.findByBookingId(booking.getBookingId()); int payId =
	 * payment.getId();
	 * 
	 * Review review = reviewService.get(payId); String nickname =
	 * user.getNickname(); model.addAttribute("nickname",nickname);
	 * model.addAttribute("booking",booking); model.addAttribute("review",review);
	 * model.addAttribute("bookingId",booking.getBookingId());
	 * 
	 * 
	 * return "member/mypage/review-detail"; }
	 */

	/*-----------리뷰수정------*/
	/*
	 * @GetMapping("/review/update/{id}") public String update(@PathVariable("id")
	 * int id,@AuthenticationPrincipal ArtagitUserDetails user,Model model) {
	 * System.out.println("여기들옴");
	 * 
	 * System.out.println(id); Review review = reviewService.getbyId(id);
	 * model.addAttribute("review",review); System.out.println(review.getPayId());
	 * int payId = review.getPayId(); model.addAttribute("payId",payId); BookingList
	 * booking = bookingService.getReviewByBookingId(payId);
	 * model.addAttribute("booking",booking); System.out.println(booking); String
	 * nickname = user.getNickname(); model.addAttribute("nickname",nickname);
	 * return "member/mypage/review-update"; }
	 */

	/*-----------리뷰삭제------*/
	/*
	 * @GetMapping("/review/del/{id}") public String delete(@PathVariable("id") int
	 * id,@AuthenticationPrincipal ArtagitUserDetails user) {
	 * System.out.println("------------들들"); int result = reviewService.del(id);
	 * return "redirect:/member/mypage/review/list"; }
	 */

//===================회원수정===================
	@GetMapping("/account-edit")
	public String update(@AuthenticationPrincipal ArtagitUserDetails user, Model model, Member member) {
		// 회원수정페이지불러올때 회원가입할때정보불러오기 user쓰기

		// member.setLoginId(user.getUsername());
		
		model.addAttribute("user", user);
		
		// System.out.println(user.getPhone());
		// memberService.update(user);

		return "member/mypage/account-edit";
	}

	@PostMapping("/account-edit")
	public String modify(MultipartFile img, HttpServletRequest request,
			@AuthenticationPrincipal ArtagitUserDetails user, Model model, Member member) throws IOException {

	
		if (!member.getPassword().isEmpty()) {
			//비번 수정할게있으면 
			String password = member.getPassword();
			String encPassword = passwordEncoder.encode(password);

			member.setPassword(encPassword);

			user.setPassword(member.getPassword());
			System.out.println(user.getPassword());
		}
		
//		String password = member.getPassword();
//		String encPassword = passwordEncoder.encode(password);
//		member.setPassword(encPassword);

		//System.out.print(img);
		if (!img.isEmpty()) {
			member.setImage(img.getOriginalFilename());
			String path = "/image";
			String realPath = request.getServletContext().getRealPath(path);
			System.out.println(realPath);

			File pathFile = new File(realPath);
			if (!pathFile.exists())
				pathFile.mkdirs();

			String fullPath = realPath + File.separator + img.getOriginalFilename();
			InputStream fis = img.getInputStream();
			OutputStream fos = new FileOutputStream(fullPath);
			byte[] buf = new byte[1024];
			int size = 0;
			while ((size = fis.read(buf)) >= 0)
				fos.write(buf, 0, size);

			fos.close();
			fis.close();
		}else {
			//img가 빈칸이면~걍 원래이미지를 넘겨라
			member.setImage(user.getImg());
		}

		System.out.println("멤버의 이름"+member.getName());
		user.setPassword(member.getPassword());
		user.setImg(member.getImage());
		user.setNickname(member.getNickname());
		user.setName(member.getName());
		user.setEmail(member.getEmail());
		user.setPhone(member.getPhone());
		model.addAttribute("user", user);

		memberService.update(member);

		// System.out.println(user.getUsername());
		return "member/mypage/account-edit";
	}

	// 좋아요 전시 리스트
	@GetMapping("like-list")
	   public String likeList(@AuthenticationPrincipal ArtagitUserDetails user,
			   					Model model) {
	      System.out.println("page@@@@@@@@@@@@@@@@");
	      List<Exhibition> list = exhService.getLikeListById(user.getId());
	      System.out.println("좋아요한 전시이이이~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	      System.out.println(list);
	      model.addAttribute("list", list);
	      
	      Member member = memberService.get(user.getId());
	      int countOfExhLike = exhLikeService.getCount(user.getId());
	      System.out.println("countOfExhLike를 알고 싶니?"+countOfExhLike);
	      
	      model.addAttribute(member);
	      model.addAttribute("countOfExhLike",countOfExhLike);
	      model.addAttribute("user",user);
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

	@GetMapping("/post-list")
	public String post(Model model, @AuthenticationPrincipal ArtagitUserDetails user) {
		List<BoardListView> list = boardService.getListById(user.getId());
		model.addAttribute("list", list);
		Member member = memberService.get(user.getId());
		model.addAttribute(member);
		model.addAttribute("user", user);
		System.out.println("로그인한 아이디가 쓴 글====>" + model);
		return "member/mypage/post-list";

	}

	/****** 좋아요한 게시글 ***********/
	@GetMapping("/post-like")
	public String getListByCategory(@AuthenticationPrincipal ArtagitUserDetails user, Model model) {
		int memId = user.getId();
		List<BoardListView> list = boardService.getLikeList(memId);
		Member member = memberService.get(user.getId());
		model.addAttribute(member);
		model.addAttribute("list", list);
		model.addAttribute("user", user);
		System.out.println("++++++++++=" + list);
		return "member/mypage/post-like";
	}
	//===== 회원 탈퇴 (useYN 변경) ==================================		
			@GetMapping("/account-edit/delete")
			public String deleteUseYN(
					@AuthenticationPrincipal ArtagitUserDetails user){
				memberService.deleteUseYN(user.getId());
				System.out.println("탈퇴ㄱ");
				return "redirect:/user/logout";
			}
}