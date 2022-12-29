package com.artagit.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artagit.web.entity.Comment;



public interface CommentService {
	public List<Comment> getListByBoardId(int id);

}
