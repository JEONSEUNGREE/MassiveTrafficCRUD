package com.massive.boardserver.service;

import com.massive.boardserver.dto.CommentDTO;
import com.massive.boardserver.dto.PostDTO;
import com.massive.boardserver.dto.TagDTO;

import java.util.List;

public interface PostService {

	void register(String id, PostDTO postDTO);

	List<PostDTO> getMyProducts(int accountId);

	void updateProducts(PostDTO postDTO);

	void deleteProduct(int userId, int productId);

	void registerComment(CommentDTO commentDTO);

	void updateComment(CommentDTO commentDTO);

	void deletePostComment(int userId, int commentId);

	void registerTag(TagDTO tagDTO);

	void updateTag(TagDTO tagDTO);

	void deletePostTag(int userId, int tagId);
}