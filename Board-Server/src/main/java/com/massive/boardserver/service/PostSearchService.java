package com.massive.boardserver.service;

import com.massive.boardserver.dto.PostDTO;
import com.massive.boardserver.dto.request.PostSearchRequest;

import java.util.List;

public interface PostSearchService {
	List<PostDTO> getProducts(PostSearchRequest postSearchRequest);
}