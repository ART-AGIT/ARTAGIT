package com.artagit.web.service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.artagit.web.dao.CorporateDao;
import com.artagit.web.dao.ExhLikeDao;
import com.artagit.web.dao.ExhibitionDao;
import com.artagit.web.entity.Corporate;
import com.artagit.web.entity.ExhLike;
import com.artagit.web.entity.Exhibition;
import com.artagit.web.entity.ExhibitionView;

@Service
public class DefaultExhibitionService implements ExhibitionService {
	
	@Autowired // Field DI (DI 외에 별도로 실행해야 하는 로직이 없는 경우, Field에 Autowired 를 한다.)
	private ExhibitionDao exhDao; // DB를 가져오는 용도
	
	@Autowired
	private ExhLikeDao exhLikeDao;
	
	@Autowired
	private CorporateDao corporateDao;
	
	// 기본생성자
	public DefaultExhibitionService() {

	}
	
	// @Autowired ==> 여기에 애너테이션을 붙이면 Constructor DI ==> 뭐가 다른거지?
	// constructor injection 랑 setter injection 의 차이점 질문하기
	public DefaultExhibitionService(ExhibitionDao exhDao) {
		this.exhDao = exhDao;
	}
	
	
	
	@Override
	public int insert (Exhibition exhibition) {
		
		exhDao.insert(exhibition);
		
		return 0;
		
	}
	

//	@Override
//	// 페이지 지정해서 목록 조회하는 메서드
//	public List<Exhibition> getList(int page, int categoryId) {
//		
//		int size = 6;
//		int offset = (page-1)*size;
//		
//		List<Exhibition> list = exhDao.getList(offset, size, categoryId);
//		
//		return list;
//	}

	// 전시 상세 정보 가져오는 메서드
	public ExhibitionView getExhById(int id, int memberId) {
		
		ExhibitionView exh = exhDao.get(id, memberId);
		
		return exh;
	}

	// [주최자] 나의 등록전시 수정
	@Override
	public int update(int id) {
		 int result = exhDao.update(id);
		 return result;
	}

	// [주최자] 나의 등록전시 삭제
	@Override
	public int delete(int id) {
		int result = exhDao.delete(id);
		return result;
	}
	
	// [주최자] 나의 등록전시 리스트
	public List<Exhibition> getListById(int id) {
		
		List<Exhibition> list =exhDao.getListByID(id);
		return list;

	}

	@Override
	public List<Exhibition> getList(int page, int museum, int state, int category) {
		int size = 6;
		int offset = (page-1)*size;
		
		List<Exhibition> list = exhDao.getList(offset, size, museum, state, category);
		
		return list;
	}


	@Override
	public List<Exhibition> getListByCategory(int page, int museum, int state, int category) {
		int size = 6;
		int offset = (page-1)*size;
		
		List<Exhibition> list = exhDao.getList(offset, size, museum, state, category);
		
		return list;
	}

	
	//나의 등록전시 개수 
	@Override
	public int countOfExh(int memId) {
		int count = exhDao.getCount(memId);
		return count;
	}

	@Override
	public int likeUp(int exhId, int memId) {
		
		ExhLike exhLike = new ExhLike(memId, exhId);

		return exhLikeDao.add(exhLike);
	}

	@Override
	public int likeDelete(int exhId, int memId) {
		ExhLike exhLike = new ExhLike(memId, exhId);
		
		return exhLikeDao.delete(exhLike);
	}

	@Override
	public int countOfLike(int exhId) {
		
		return exhLikeDao.count(exhId);
	}

	@Override
	public List<ExhibitionView> getListBySearch(String query, int memberId) throws SQLSyntaxErrorException {
		int page = 1;
		int size = 6;
		int offset = (page-1)*size;
		
		List<ExhibitionView> list = exhDao.getListBySearch(offset, size, memberId, query);
		
		return list;
	}

	@Override

	public List<ExhibitionView> getListByMemberId(int page, int museum, int state, int category, int memberId) {
		int size = 6;
		int offset = (page-1)*size;
		
		List<ExhibitionView> list = exhDao.getListByMemberId(offset, size, museum, state, category, memberId);
		return list;
	}

	@Override
	public Exhibition getExhById(int exhId) {
		// TODO Auto-generated method stub
		
		Exhibition exh = exhDao.getexh(exhId);
		
		return exh;
	}


	public int reg(Exhibition exhibition) {
		// TODO Auto-generated method stub
		return 0;
	}

}
