package com.artagit.web.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Comment;

@Mapper
public interface CommentDao {

	List<Comment> getList(
			int postId,
			int memId,
			String content,
			Date regDate
			);
	
	List<Comment> getListByBoardId(int id);
	
	Comment get(int id);
	
	int count(String input);
	int insert(Comment comment);
	int update(Comment comment);
	int delete(int id);
	
}
	
