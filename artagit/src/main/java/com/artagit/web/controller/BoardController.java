package com.artagit.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.entity.Notice;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.NoticeService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	
	@Autowired
	private NoticeService noticeService;
	/*************게시글 리스트 불러오기*********/
	@GetMapping("list")
	public String list(
		
		@RequestParam(defaultValue = "1", name ="p")int page,
		Model model){
		List<BoardListView> list = service.getListInit(page);
		List<Notice> noticeList = noticeService.getList(page);
	
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("list",list);
//		
		
		return "board/list";
			
		}
	
	/***********게시글 등록 시작****************/
	@GetMapping("reg")
	public String boardReg() {
	
		return "board/reg";
	}
	
	@PostMapping("reg")
	public String reg(Board board) {
		
	
		System.out.println("등록한 글 ===> "+board);
		service.reg(board);
		
		return "redirect:list";
	}
	/*******게시글 등록 끝*****************/
		
	
	/************게시글 디테일*************/
	@GetMapping("{id}")
	public String detail(
		
		@PathVariable("id")int id,
		Model model){
		Board board = service.get(id);
		model.addAttribute("board",board);
	
		
		
		System.out.println("id:"+ id);
		
		
		return "board/detail";
			
		}
	/************게시글 삭제***************/
	@PutMapping("{id}")
	public Map<String, Object> delete(
			@PathVariable("id") int id){
	
	int result = service.delete(id);
	
	Map<String, Object> dto = new HashMap<>();
      dto.put("status", 200);//http가 갖고있는 기본 상태값
      dto.put("resultObject", result);
     
	return dto;
	
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
