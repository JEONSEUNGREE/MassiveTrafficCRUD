package com.massive.boardserver.mapper;

import com.massive.boardserver.dto.PostDTO;
import com.massive.boardserver.dto.request.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostSearchMapper {
	public List<PostDTO> selectPosts(PostSearchRequest postSearchRequest);
	public List<PostDTO> getPostByTag(String tagName);
}