package com.artagit.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.artagit.web.entity.Post;

@Mapper
public interface PostDao {
	
	List<Post> getList(
			int page,
			String field,
			String input
			);
	
	Post get(int id);
	
	int count(String input);
	
	int insert(Post post);
	int update(Post post);
	int delete(int id);
	

}
