package com.artagit.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artagit.web.dao.BoardDao;
import com.artagit.web.dao.CommentDao;
import com.artagit.web.entity.Comment;

@Service
public class DefaultCommentService implements CommentService{

	@Autowired
	private CommentDao commentDao;
	


	@Override
	public List<Comment> getListByBoardId(int id) {
		// TODO Auto-generated method stub
		return commentDao.getListByBoardId(id);
	}

}
