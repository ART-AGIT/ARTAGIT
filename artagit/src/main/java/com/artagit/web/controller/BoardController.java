package com.artagit.web.controller;

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
			
		List<BoardListView> list = service.getListInit(page);
		model.addAttribute("list",list);
		
		
		return "board/list";
			
		}

	
	
	
	/***게시글 내용 조회****/
		
	
	@GetMapping("{id}")
	   public String detail(
	      
	      @PathVariable("id")int id,
	      Model model, @AuthenticationPrincipal ArtagitUserDetails user){
		
		System.out.println("와 이제 detail이 안들어가져"+id);
	      Board board = service.get(id);
	      model.addAttribute("board",board);
	   
	      
	      //Comment 조회
	      model.addAttribute("user",user);
	      
	      System.out.println(user);
	      System.out.println(board);

	      
	      List<Comment> comments = commentService.getNickname(id);
	      model.addAttribute("comments",comments);

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