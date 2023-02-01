package com.artagit.web.controller.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.Comment;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.CommentService;
import com.artagit.web.service.NoticeService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member/board/")
public class MemberBoardController {

	@Autowired
	private BoardService service;
	@Autowired
	private CommentService commentService;
	@Autowired
	private NoticeService noticeService;

	/************ 게시글 디테일 *************/
	@GetMapping("{id}")
	public String detail(

			@PathVariable("id") int id, Model model, @AuthenticationPrincipal ArtagitUserDetails user,
			HttpServletRequest request,HttpServletResponse response) {
		int memId = user.getId();
		
		//게시글 디테일에 필요한 정보 넣고 보여주기
		Board board = service.getDetail(id,memId);
		model.addAttribute("board",board);	
		model.addAttribute("user", user);
		List<Comment> comments = commentService.getNickname(id);
		model.addAttribute("comments", comments);

		
		//조회수(중복 제거)
		Cookie oldCookie = null; //쿠키 객체 만들고 초기화
		Cookie[] cookies = request.getCookies();
		if(cookies !=null ) { //받아온 쿠키가 postView갖고있는 쿠키면 oldCookie에 대입
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("postView")) {
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
			
			//쿠키가 null이면 postView쿠키를 만들어준다.
		}else {
			service.hitUp(id);
			Cookie newCookie = new Cookie("postView","["+id+"]");
			newCookie.setPath("/");
			newCookie.setMaxAge(60*60*24);
			response.addCookie(newCookie);
		}


		
		return "member/board/detail";

	}

	/************ 게시글 삭제 ***************/
	@GetMapping("delete")
	public String delete(int id) {
		System.out.println("삭제");
		service.delete(id);

		return "redirect:../../board/list";

	}

	/*********** 게시글 등록 시작 ****************/
	@GetMapping("reg")
	public String boardReg() {

		return "member/board/reg";
	}

	@PostMapping("reg")
	public String reg(int roleId, MultipartFile img1,MultipartFile img2,MultipartFile img3,MultipartFile img4,Board board, HttpServletRequest request,
			Model model,
			@AuthenticationPrincipal ArtagitUserDetails user)
			throws IOException {
		
		
		System.out.println("board"+board.toString());
		System.out.println("img1"+img1.getOriginalFilename());
		System.out.println("img2"+img2.getOriginalFilename());
		System.out.println("img3"+img3.getOriginalFilename());
		System.out.println("img4"+img4.getOriginalFilename());
		List<MultipartFile> imgList = new ArrayList<>();
		
		if(!img1.getOriginalFilename().isEmpty()) {
			board.setImage1(img1.getOriginalFilename());
			imgList.add(img1);
		}
		if(!img2.getOriginalFilename().isEmpty()) {
			board.setImage2(img2.getOriginalFilename());
			imgList.add(img2);
		}
		if(!img3.getOriginalFilename().isEmpty()) {
			board.setImage3(img3.getOriginalFilename());
			imgList.add(img3);
		}
		if(!img4.getOriginalFilename().isEmpty()) {
			board.setImage4(img4.getOriginalFilename());
			imgList.add(img4);
		}
		
		
	
		for(MultipartFile img:imgList) {
			System.out.println(img);
			
			if(!img.isEmpty()) {
				String path = "/image/board"; 
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
				
			}
			
		}
		
		int memId = user.getId();
		board.setMemId(memId);	
		System.out.println(imgList.size());
		int result =service.reg(board);
		System.out.println(result);
		String id = String.valueOf(board.getId());
		return "redirect:/member/board/"+id;
	}

	/******* 게시글 등록 끝 *****************/

   /*********게시글 수정*************/
   @GetMapping("edit/{id}")
   public String Boardedit(@PathVariable("id") int id,Model model) {
       
	   Board board = service.get(id);
	   System.out.println("수정은 왜 또 안돼ㅡㅡㅡㅡ?");
	   model.addAttribute("board",board);
       return "member/board/edit";
   }
 
   /*
	@PostMapping("edit")
	public String edit(int roleId, MultipartFile img,Board board, HttpServletRequest request,
			Model model,
			@AuthenticationPrincipal ArtagitUserDetails user)
			throws IOException {
		model.addAttribute(user);
		
		int memId = user.getId();
		System.out.println("이미지이름" + img.getOriginalFilename());
		board.setMemId(memId);
		
		if (!img.isEmpty()) {
			board.setImage(img.getOriginalFilename());
			
		
		
			String path = "/image"; // 어디에서 돌아갈지 모르니 운영되고 있는 home directory에서 생각 앞쪽은 어케될지 모름
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
		}
		
		service.edit(board);
		
		String OriginalId = String.valueOf(board.getId());
		
		System.out.println("등록한 글 ===> " + img);
//		String referer = request.getHeader("Referer");
//		System.out.println(referer);
		
		return "redirect:/member/board/"+OriginalId;
	}
	*/
	
	
	
}
