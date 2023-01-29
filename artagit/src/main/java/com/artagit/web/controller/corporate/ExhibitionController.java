package com.artagit.web.controller.corporate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.artagit.web.entity.ArtagitOidcUser;
import com.artagit.web.entity.ArtagitUserDetails;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.Local;
import com.artagit.web.entity.PayList;
import com.artagit.web.service.CorporateService;
import com.artagit.web.service.ExhibitionService;
import com.artagit.web.service.LocalService;
import com.artagit.web.service.MuseumService;
import com.artagit.web.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import jakarta.servlet.http.HttpServletRequest;

@Controller("corporaterController")
@RequestMapping("/corp/exh/")
public class ExhibitionController {
	
	@Autowired
	private ExhibitionService service;
	
	@Autowired
	private CorporateService corporateService;
	
	@Autowired
	private MuseumService museumService;
	
	@Autowired
	private LocalService localService;
	
//	@Autowired
//	private BookingService bookingService;

//	@Autowired
//	private PaymentService paymentService;
	
	@Autowired
	private PaymentService payListService;
	
	//내가 등록한 전시리스트 ========================
	@GetMapping("list")
	public String list(Model model,@AuthenticationPrincipal ArtagitUserDetails user) {
		int userId = user.getId();
		System.out.println(userId);
		List<Exhibition> list = service.getListById(userId);
		int countOfExh = service.getCountOfExh(user.getId());
		
		System.out.println("img"+user.getImg());
		System.out.println("user"+user);
		
		model.addAttribute("user",user);
		model.addAttribute("nickname",user.getUsername());
		model.addAttribute("list",list);
		model.addAttribute("countOfExh",countOfExh);
		
		return "corporator/mypage/exh-list";
	}
	
	
	// 주최자가 등록한 전시 상세 ========================
	@GetMapping("{id}")
	public String detail(
			@PathVariable("id") int exhId,
			Model model) {
		// 전시 상세 내용
		Exhibition exh = service.getExhById(exhId);
		model.addAttribute("exh",exh);
		Corporate corporate = corporateService.getCorpById(exh.getCorpId());
		model.addAttribute("corporate",corporate);
		Local local = localService.getLocalById(corporate.getLocalId());
		model.addAttribute("local",local);
		
		// ** 결제 내역
		List<PayList> payList = payListService.getPayListById(exhId);
		model.addAttribute("payList",payList);
		
		
		return "corporator/mypage/exh-detail";
	}

	// 주최자가 등록한 전시 수정 ========================
		@Transactional
		@PostMapping("update")
		@ResponseBody
		public String update(@RequestBody ObjectNode exhInfo) throws JsonProcessingException, IllegalArgumentException {
			System.out.println("update 메서드 진입");
			
			// ObjectMapper = json 형태의 데이터를 java Object 로 변환해주는 클래스 (json 라이브러리 Jackson)
			ObjectMapper mapper = new ObjectMapper();

			// 클라이언트에서 넘어온 json의 키값을 가지고 클래스 정보를 얻어 자동으로 매핑을 해준다.
			// 매핑된 값들을 각각의 객체에 담기.
			Exhibition exh = mapper.treeToValue(exhInfo.get("exh"), Exhibition.class);
			Corporate corp = mapper.treeToValue(exhInfo.get("corp"), Corporate.class);
			Local local = mapper.treeToValue(exhInfo.get("local"), Local.class);
			
			System.out.println("전시데이터 ===> " + exh);
			System.out.println("주최자데이터 ===> " + corp);
			System.out.println("지역데이터 ===> " + local);
			
			// 각 객체를 인자로 넘겨 update 진행
			int result = service.update(exh);
						 corporateService.update(corp);
						 localService.update(local);
			
			System.out.println("전시정보 update결과: "+result);
			System.out.println(exh.getId()+"번 전시 수정완료");
			return "redirect:{id}";
		}
	
	// 주최자가 등록한 전시 삭제 ========================
	@GetMapping("delete")
	public String delete(int id) {
//		@PathVariable("exhId")
		service.delete(id);
		
		System.out.println("주최자 등록한 전시(id==>"+ id +") 삭제(useYn = N)완료");
		 return "redirect:list";
	}
	
	//===================전시등록하기====================
	@GetMapping("reg")
	public String reg(Model model, @AuthenticationPrincipal ArtagitOidcUser user) {
		//전시페이지 불러오면 주최자정보입력돼있기
		System.out.println(user);
		model.addAttribute("user",user);
		System.out.println(user.getAddress());
		return "corporator/mypage/exh-reg";
	}
	
	@PostMapping("insert")
//	@ResponseBody
	public String insert(MultipartFile file1,MultipartFile file2, Exhibition exhibition,HttpServletRequest request
			,@AuthenticationPrincipal ArtagitUserDetails user) throws IOException{
		
		System.out.println("들어옴들어옴");
		System.out.println("poster" +file1);
		System.out.println("detailImage" +file2);
		System.out.println("exhibition" +exhibition);
		System.out.println("주최자의 전시등록에서 user" +user.getId());
		
		System.out.println("이미지파일명"+file1.getOriginalFilename());
		System.out.println("이미지파일명"+file2.getOriginalFilename());
		
		exhibition.setCorpId(user.getId());
		exhibition.setPoster(file1.getOriginalFilename());
		exhibition.setDetailImage(file2.getOriginalFilename());
		List<MultipartFile> imgList = new ArrayList<>();

		imgList.add(file1);
		imgList.add(file2);
		
		System.out.println(imgList);
		
		for(MultipartFile file: imgList) {
			
			if(!file.isEmpty()) {
				String path = "/image/poster"; 
				String realPath = request.getServletContext().getRealPath(path);
				System.out.println(realPath);
				
				File pathFile = new File(realPath);
				if (!pathFile.exists())
					pathFile.mkdirs();
				
				String fullPath = realPath + File.separator + file.getOriginalFilename();
				InputStream fis = file.getInputStream();
				OutputStream fos = new FileOutputStream(fullPath);
				byte[] buf = new byte[1024];
				int size = 0;
				while ((size = fis.read(buf)) >= 0)
					fos.write(buf, 0, size);
				
				fos.close();
				fis.close();
				
			}
		}
		System.out.println(exhibition);
		Exhibition result = service.insert(exhibition,user.getId());
		String id = String.valueOf(result.getId());
		System.out.println(id);
		return "redirect:/exhibition/"+id;
	 }
	
	

	// 주최자가 등록한 전시 데이터 수정페이지에 불러오기
	@GetMapping("modify/{id}")
	public String getBeforeUpdate(@PathVariable("id") int exhId, Model model) {
		
		System.out.println("가져온 전시 정보 id ===> "+ exhId);
		
		Exhibition exh = service.getExhById(exhId);
		model.addAttribute("exh", exh);
		Corporate corporate = corporateService.getCorpById(exh.getCorpId());
		model.addAttribute("corporate",corporate);
		Local local = localService.getLocalById(corporate.getLocalId());
		model.addAttribute("local",local);
		
		return "corporator/mypage/exh-modify"; // 전시를 등록하는 페이지 (재활용)
	}
//		
//	// 주최자가 등록한 전시 삭제 ========================
//	@GetMapping("delete")
//	public String delete(int id) {
////		@PathVariable("exhId")
//		service.delete(id);
//		
//		System.out.println("주최자 등록한 전시(id==>"+ id +") 삭제(useYn = N)완료");
//		 return "redirect:list";
//	}
}
