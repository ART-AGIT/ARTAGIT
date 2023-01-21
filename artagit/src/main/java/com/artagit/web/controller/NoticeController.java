package com.artagit.web.controller;

import java.util.List;

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
import com.artagit.web.entity.Notice;
import com.artagit.web.service.NoticeService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	public NoticeController() {

	}
	
	public NoticeController(NoticeService service) {
		this.service = service;
	}
	
	/********************** 공지사항 목록 조회 시작 **********************/
//	@GetMapping("notice/list")
	@GetMapping("customer_notice")
	public String list(
			@RequestParam(defaultValue = "1", name="p") int page,
			Model model) {
		
		int size = 6;
		int offset = (page-1)*size;
		
		List<Notice> list = service.getList(page);
		model.addAttribute("list", list);
		
		return "customer-center";
	}
	
	// 공지 상세내용 불러오기
	@GetMapping("customer_notice/{id}")
	@ResponseBody
	public Notice detail(
			@PathVariable("id") int id,
			Model model) {
		System.out.println("id:"+id);
		Notice notice = service.getNoticeById(id);
		model.addAttribute("notice", notice);
			return notice;
	}
	

	@GetMapping("notice/{id}")
	public String communityDetail(@PathVariable("id") int id, Model model, @AuthenticationPrincipal ArtagitUserDetails user,
			HttpServletRequest request,HttpServletResponse response){
		System.out.println("noticeDetail"+id);
		Notice notice = service.getNoticeById(id);
		model.addAttribute("notice",notice);
		
		//조회수(중복 제거)
				Cookie oldCookie = null; //쿠키 객체 만들고 초기화
				Cookie[] cookies = request.getCookies();
				if(cookies !=null ) { //받아온 쿠키가 postView갖고있는 쿠키면 oldCookie에 대입
					for(Cookie cookie: cookies) {
						if(cookie.getName().equals("noticeView")) {
							oldCookie = cookie;
						}
					}
				}
				//만약 쿠키가 null이 아니고
				if(oldCookie!=null) {
					//value에 [id]를 포함하는 쿠키가 없다면 만들어준다.
					if(!oldCookie.getValue().contains("["+String.valueOf(id).toString()+"]")) {
					service.hitUp(id);
					oldCookie.setValue(oldCookie.getValue()+"_["+id+"]");
					oldCookie.setPath("/");
					oldCookie.setMaxAge(60*60*24);
					response.addCookie(oldCookie);
					}//null이아니고 id를 포함한다면 아무일도 없음.
					
					//쿠키가 null이면 noticeView쿠키를 만들어준다.
				}else {
					service.hitUp(id);
					Cookie newCookie = new Cookie("noticeView","["+id+"]");
					newCookie.setPath("/");
					newCookie.setMaxAge(60*60*24);
					response.addCookie(newCookie);
				}
		
		
		return "notice/detail";
		
		
		
	}
}

