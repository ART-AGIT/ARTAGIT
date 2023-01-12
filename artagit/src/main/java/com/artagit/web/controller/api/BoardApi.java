package com.artagit.web.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Board;
import com.artagit.web.entity.BoardListView;
import com.artagit.web.service.BoardService;
import com.artagit.web.service.NoticeService;


@RestController
@RequestMapping("/boardApi/")
public class BoardApi {

   @Autowired
   private BoardService service;
   
   @Autowired
   private NoticeService noticeService;
   /*************게시글 리스트 불러오기*********/
   @GetMapping("boards")
   public List<BoardListView> getListByCategory(
         @RequestParam("c") int roleId){
      List<BoardListView> list = service.getList(roleId);
      System.out.println("++++++++++="+list);
      return list;
   }
   /*********게시글 삭제*************/
   @DeleteMapping("delete/{id}")
   public Map<String, Object> delete(@PathVariable("id") int id) {
      int result = service.delete(id);
      
      Map<String, Object> dto = new HashMap<>(); // result 객체
      dto.put("status", 200); // http가 갖고 있는 기본 상태값
      dto.put("resultObject", result);
      
      System.out.println("게시글(id==>"+ id +") 삭제(useYn = N)완료");
       return dto;
   }

//   @PostMapping("edit/{id}")
//   public Map<String, Object> edit(@PathVariable("id") int id) {
//      int result = service.edit(id);
//      
//      Map<String, Object> dto = new HashMap<>(); // result 객체
//      dto.put("status", 200); // http가 갖고 있는 기본 상태값
//      dto.put("resultObject", result);
//      
//      System.out.println("게시글(id==>"+ id +") 수정완료");
//       return dto;
//   }
   
   
//   /******좋아요한 게시글***********/
   @PutMapping("like/{id}")
   public Map<String, Object> likeUp(@PathVariable("id") int id,@AuthenticationPrincipal ArtagitUserDetails user){
	   
	   System.out.println("좋아요 id가 넘어오나요?"+id);
	   int result = service.likeUp(id, user.getId());
//	   int count = service.countOfLike(id);
	   Map<String, Object> dto = new HashMap<>();
		//HTTP 가 가지고있는 기본 상태값
		dto.put("status", 200);
		dto.put("resultObject", result);
//		dto.put("countNum", count);
		
		return dto;
   }
}
      
      
      