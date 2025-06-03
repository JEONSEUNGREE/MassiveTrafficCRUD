package com.massive.boardserver.service.impl;

import java.util.List;

import com.massive.boardserver.dto.PostDTO;
import com.massive.boardserver.dto.request.PostSearchRequest;
import com.massive.boardserver.mapper.PostSearchMapper;
import com.massive.boardserver.service.PostSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PostSearchServiceImpl implements PostSearchService {

	@Autowired
	private PostSearchMapper productSearchMapper;

	@Async
	@Cacheable(
		value = "getProducts",
		key = "'getProducts' + #postSearchRequest.getName() + #postSearchRequest.getCategoryId()")
	@Override
	public List<PostDTO> getProducts(PostSearchRequest postSearchRequest) {
		List<PostDTO> postDTOList = null;
		try {
			postDTOList = productSearchMapper.selectPosts(postSearchRequest);
		} catch (RuntimeException e) {
			log.error("selectPosts 실패");
		}
		return postDTOList;
	}


	public List<PostDTO> getPostByTag(String tagName) {
		List<PostDTO> postDTOList = null;
		try {
			postDTOList = productSearchMapper.getPostByTag(tagName);
		} catch (RuntimeException e) {
			log.error("getPostByTag 실패", e.getMessage());
		}
		return postDTOList;
	}

}
