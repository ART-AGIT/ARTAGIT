package com.artagit.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.Comment;
import com.artagit.web.entity.Notice;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.CommentService;
import com.artagit.web.service.NoticeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private NoticeService noticeService;
	/*************게시글 리스트 불러오기*********/
	@GetMapping("list")
	public String list(
		@RequestParam(defaultValue = "1", name ="p")int page,
		Model model,
		HttpSession session){
		Board roleId = new Board();
		roleId.setRoleId(0);
		int category = 0;
		System.out.println("category?"+category);
		List<BoardListView> board = service.getListInit(page, 0,category);
		List<Notice> notice = noticeService.getListInit(page,0,category);
		model.addAttribute("noticeList",notice);
		model.addAttribute("roleId", roleId);
		model.addAttribute("boardList",board);
		
		
		
		return "board/list";
			
		}
	
	//게시글 검색 결과
	@GetMapping("search")
	public String searchList(
		@RequestParam(defaultValue = "", name ="q")String query,
		Model model){
		System.out.println("ㅎㅎ");
		Board roleId = new Board();
		List<BoardListView> board = service.getSearchList(query);
		model.addAttribute("roleId", roleId);		
		model.addAttribute("boardList",board);	
		System.out.println(board);
		return "board/searchlist";
			
		}
	
	@GetMapping("list{id}")
	public String listByCategory(
		
		@RequestParam(defaultValue = "1", name ="p")int page,
		@PathVariable("id") int id,
		Model model,
		HttpSession session){
		Board roleId = new Board();
		int category = 0;
		if(id!=0) {
			category = id;
			roleId.setRoleId(id);
		}
		else
			roleId.setRoleId(0);
		System.out.println("category?"+roleId.getRoleId());
		List<BoardListView> board = service.getListInit(page, 0,category);
		
		
		List<Notice> notice = noticeService.getListInit(page,0,category);
		model.addAttribute("boardList",board);
		model.addAttribute("noticeList",notice);
		model.addAttribute("roleId", roleId);
		System.out.println("model에 들어가는지"+notice);
		
		return "board/list";
			
		}


	
	
	/***게시글 내용 조회****/
		
	
	@GetMapping("{id}")
	   public String detail(
	      
	      @PathVariable("id")int id,
	      Model model, @AuthenticationPrincipal ArtagitUserDetails user){
			
		
	      Board board = service.get(id);
	      model.addAttribute("board",board);
	     
	      
	      //Comment 조회
//	      model.addAttribute("user",user);
//	      
//	      
//	      List<Comment> comments = commentService.getNickname(id);
//	      model.addAttribute("comments",comments);
	      return "member/board/detail";

	         
	      }
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
////	@GetMapping("reg")
////	public String boardReg(Board board) {
////		return "board/reg";
////	}
//	@PostMapping("reg")
//	public String reg(MultipartFile img, String title,String content,HttpServletRequest request) throws IOException {
//		
//		
//		service.add()
//		if(!img.isEmpty()) {
//			String path = "/post/image";
//			String realPath = request.getServletContext().getRealPath(path);
//		
//		
//		File pathFile = new File(realPath);
//		if(!pathFile.exists())
//			pathFile.mkdirs();
//		
//		String fullPath = realPath+File.separator+img.getOriginalFilename();
//		InputStream fis = img.getInputStream();
//		OutputStream fos = new FileOutputStream(fullPath);
//		
//		byte[] buf = new byte[1024];
//		int size = 0;
//		while((size=fis.read(buf))>=0)
//			fos.write(buf,0,size);
//		
//		fos.close();
//		fis.close();
//		
//		}
//		return "redirect:list";
//	}
	
	
	
	
	
	
}