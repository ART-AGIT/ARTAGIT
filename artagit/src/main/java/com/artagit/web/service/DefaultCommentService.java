package com.artagit.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.CommentDao;
import com.artagit.web.dao.MemberDao;
import com.artagit.web.entity.Comment;
import com.artagit.web.entity.Member;

@Service
public class DefaultCommentService implements CommentService {
	
	@Autowired
	private CommentDao dao;

	
	@Autowired
	private MemberDao memberDao;

	


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
	public int delete(Comment comment) {
		return dao.delete(comment);
	}

	
	
	@Override
	public Map<String, Object> write(Comment comment) {
		
		Member member = memberDao.get(comment.getMemId());
		dao.add(comment);
		Comment lastOne = dao.getLast();
		
		Map<String, Object> dto = new HashMap<>();
		dto.put("member", member.getNickname());
		dto.put("comment", lastOne);
//		System.out.println(lastOne);
		return dto;
	}

	@Override
	public List<Comment> getNickname(int id) {
		
		List<Comment> list  = dao.getNickname(id);
		System.out.println("====="+id);
		return list;
	}

	@Override
	public Comment modifyTest(Comment comment, int id) {	
		Comment result = dao.modifyTest(comment);
		
		return result;
	}


	


	

	

}
