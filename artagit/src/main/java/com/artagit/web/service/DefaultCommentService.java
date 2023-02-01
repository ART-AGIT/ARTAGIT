package com.artagit.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.BoardReportDao;
import com.artagit.web.dao.CommentDao;
import com.artagit.web.dao.CommentReportDao;
import com.artagit.web.dao.MemberDao;
import com.artagit.web.entity.BoardReport;
import com.artagit.web.entity.Comment;
import com.artagit.web.entity.CommentReport;
import com.artagit.web.entity.Member;

@Service
public class DefaultCommentService implements CommentService {
	
	@Autowired
	private CommentDao dao;

	
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private CommentReportDao reportDao;
	
	@Autowired
	private BoardReportDao boardReportDao;
	
	

	@Override
	public Map<String, Object> modify(Comment comment) {
		Member member = memberDao.get(comment.getMemId());
//		System.out.println(comment);
		dao.modify(comment);
		Comment lastOne = dao.getModifyOne(comment);
		System.out.println(member);
		
		Map<String, Object> dto = new HashMap<>();
//		dto.put("member", member.getNickname());
		dto.put("comment", lastOne);
		return dto;
		
	}

	@Override
	public int delete(int id) {
		
		int result = dao.delete(id);
		
		return result;
		
	}

	
	
	@Override
	public Map<String, Object> write(Comment comment) {
		
		Member member = memberDao.get(comment.getMemId());
		dao.add(comment);
		Comment lastOne = dao.getLast();
		
		Map<String, Object> dto = new HashMap<>();
		dto.put("member", member);
		dto.put("comment", lastOne);
		return dto;
	}

	@Override
	public List<Comment> getNickname(int id) {
		
		List<Comment> list  = dao.getNickname(id);
		return list;
	}

	@Override
	public Comment getCommentId(int id) {
		Comment result = dao.getCommentId(id);
				List<Comment>	 result1 = dao.getList(id);
				System.out.println("rererere"+result1);
		return result;
		
	}

	@Override
	public int regReport(CommentReport report) {
		
		int result = reportDao.insert(report);
		
		return result;
	}

	@Override
	public int regReportBoard(BoardReport report) {
		
		int result = boardReportDao.insert(report);
		
		return result;
	}




	


	

	

}
