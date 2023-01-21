package com.artagit.web.controller.corporate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	@PostMapping("update")
	@ResponseBody
	public String update(@RequestBody HashMap<String,Object> map) {
		System.out.println("update 메서드 진입");
		HashMap<String, Object> exhList = (HashMap<String, Object>) map.get("exh");
		Exhibition exh = new Exhibition();
		// 아이디
		exh.setId(Integer.parseInt(String.valueOf(exhList.get("id"))));		
		exh.setName(String.valueOf(exhList.get("name")));
		exh.setArtist(String.valueOf(exhList.get("artist")));
		exh.setStartDate(String.valueOf(exhList.get("startDate")));
		exh.setEndDate(String.valueOf(exhList.get("endDate")));
		exh.setStartTime(String.valueOf(exhList.get("startTime")));
		exh.setEndTime(String.valueOf(exhList.get("endTime")));
		exh.setTicketPrice(Integer.parseInt(String.valueOf(exhList.get("ticketPrice"))));
		exh.setTicketStock(Integer.parseInt(String.valueOf(exhList.get("ticketStock"))));
		exh.setContent(String.valueOf(exhList.get("content")));
		exh.setHomepage(String.valueOf(exhList.get("homepage")));
		
		
		HashMap<String, Object> corpList = (HashMap<String, Object>) map.get("corp");
		Corporate corp = new Corporate();
		corp.setId(Integer.parseInt(String.valueOf(corpList.get("id"))));
		corp.setMuseumName(String.valueOf(corpList.get("museumName")));
		corp.setName(String.valueOf(corpList.get("name")));
		corp.setAddress(String.valueOf(corpList.get("address")));
		corp.setPhone(String.valueOf(corpList.get("phone")));
		corp.setManager(String.valueOf(corpList.get("manager")));

		HashMap<String, Object> localList = (HashMap<String, Object>) map.get("local");
		Local local = new Local();
		local.setId(Integer.parseInt(String.valueOf(localList.get("id"))));
		local.setName(String.valueOf(localList.get("name")));
		
		
		System.out.println("전시데이터 ===> " + exh);
		System.out.println("주최자데이터 ===> " + corp);
		System.out.println("지역데이터 ===> " + local);
		
		int result = service.update(exh);
		System.out.println("전시정보 update결과: "+result);

		corporateService.update(corp);
		localService.update(local);
		
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
	public String reg(Model model, @AuthenticationPrincipal ArtagitUserDetails user) {
		//전시페이지 불러오면 주최자정보입력돼있기
		System.out.println(user);
		model.addAttribute("user",user);
		System.out.println(user.getAddress());
		return "corporator/mypage/exh-reg";
	}
	
	@PostMapping("insert")
	@ResponseBody
	public String insert(@RequestParam("poster") MultipartFile poster, @RequestParam("detailImage") MultipartFile detailImage, Exhibition exhibition,HttpServletRequest request) throws IOException{
		
		service.insert(exhibition);
	//	System.out.print("전시 :" +exhibition.toString());
		
			
//		exhibition.setPoster(exhibition.getPoster());
//		exhibition.setDetailImage(file.getOriginalFilename());
//		System.out.println("이미지이름" + poster);
//		System.out.println("이미지이름" + detailImage);
//		
//		for(MultipartFile mf : uploadFile)
//			System.out.println(mf);
		
		
//		if (!exhibition.getPoster().isEmpty()) {
//				String path = "/image"; 
//				String realPath = request.getServletContext().getRealPath(path);
//				System.out.println(realPath);
//
//				File pathFile = new File(realPath);
//				if (!pathFile.exists())
//					pathFile.mkdirs();
//
//				String fullPath = realPath + File.separator + exhibition.getPoster();
//				//InputStream fis = file.getInputStream();
//				OutputStream fos = new FileOutputStream(fullPath);
//				byte[] buf = new byte[1024];
//				int size = 0;
//				while ((size = fis.read(buf)) >= 0)
//					fos.write(buf, 0, size);
//
//				fos.close();
//				fis.close();
//			}

		//int result = 0;
		// result =
		
		
//		try {
//		}
//		catch(Exception e) {
//			result = -1;
//		}
//		
//		if(result >0 ) {
//			//log
//		}else if(result == 0) {
//		
//		}else if( result == -1) {
//		 
//		}else {
//			
//		}
		return "redirect:list";
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
