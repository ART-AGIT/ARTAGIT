package com.artagit.web.controller.member;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.Comment;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.CommentService;
import com.artagit.web.service.NoticeService;

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
			HttpServletRequest requqest,HttpServletResponse response) {

		//게시글 디테일에 필요한 정보 넣고 보여주기
		Board board = service.getDetail(id);
		model.addAttribute("board",board);	
		model.addAttribute("user", user);

		//조회수(중복 제거)
		


		List<Comment> comments = commentService.getNickname(id);
		model.addAttribute("comments", comments);
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
	public String reg(int roleId, MultipartFile img,Board board, HttpServletRequest request,
			Model model,
			@AuthenticationPrincipal ArtagitUserDetails user)
			throws IOException {
		System.out.println(board.toString());
		model.addAttribute(user);
		System.out.println(user.getId());
		
		int memId = user.getId();
		System.out.println("이미지이름" + img.getOriginalFilename());
		board.setMemId(memId);
		board.setImage(img.getOriginalFilename());
		if (!img.isEmpty()) {
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
		
		service.reg(board);
		
		String id = String.valueOf(board.getId());
		
		System.out.println("등록한 글 ===> " + img);
//		String referer = request.getHeader("Referer");
//		System.out.println(referer);
		
		return "redirect:/member/board/"+id;
	}

	/******* 게시글 등록 끝 *****************/

   /*********게시글 수정*************/
   @GetMapping("edit/{id}")
   public String Boardedit(@PathVariable("id") int id,Model model) {
       
	   Board board = service.get(id);
	   model.addAttribute("board",board);
       
       return "member/board/edit";
   }
 
   
	@PostMapping("edit")
	public String edit(int roleId, MultipartFile img,Board board, HttpServletRequest request,
			Model model,
			@AuthenticationPrincipal ArtagitUserDetails user)
			throws IOException {
		model.addAttribute(user);
		
		int memId = user.getId();
		System.out.println("이미지이름" + img.getOriginalFilename());
		board.setMemId(memId);
		board.setImage(img.getOriginalFilename());
		
		if (!img.isEmpty()) {
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
		
		System.out.println(board.toString());
		service.edit(board);
		
		String OriginalId = String.valueOf(board.getId());
		
		System.out.println("등록한 글 ===> " + img);
//		String referer = request.getHeader("Referer");
//		System.out.println(referer);
		
		return "redirect:/member/board/"+OriginalId;
	}
	
}
