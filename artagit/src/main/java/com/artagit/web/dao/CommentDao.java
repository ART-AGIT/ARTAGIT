package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Comment;

@Mapper
public interface CommentDao {

	List<Comment> getList(int postId);
	
	
	
//	Comment get(int id);
	
	int count(String input);
//	int write(Comment comment);
	int modify(Comment comment);
	int delete(Comment comment);



	Comment write(int postId, int memId, String content);




	void add(Comment comment);


	Comment getLast();



	List<Comment> getNickname(int id);
	
}
	
