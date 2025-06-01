package com.massive.boardserver.service;

import com.massive.boardserver.dto.PostDTO;

import java.util.List;

public interface PostService {

	void register(String id, PostDTO postDTO);

	List<PostDTO> getMyProducts(int accountId);

	void updateProducts(PostDTO postDTO);

	void deleteProduct(int userId, int productId);
}