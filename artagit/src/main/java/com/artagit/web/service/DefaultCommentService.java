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
	public List<Comment> getList(int postId) {
		return dao.getList(postId);
	}


	@Override
	public int modify(Comment comment) {
		return dao.modify(comment);
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
		return dto;
	}

	@Override
	public List<Comment> getNickname(int id) {
		
		List<Comment> list  = dao.getNickname(id);
		System.out.println("====="+id);
		return list;
	}


	

}