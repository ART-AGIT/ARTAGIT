package com.artagit.web.service;

import java.util.List;
import java.util.Map;

import com.artagit.web.entity.Comment;

public interface CommentService {
	

	
	
	Map<String, Object> modify(Comment comment);
	int delete(int id);


//	Comment write(int postId, int memId, String content, String string);

	List<Comment> getNickname(int id);

	Map<String, Object> write(Comment comment);
	
	Comment getCommentId(int id);
	
	






	
	
}
