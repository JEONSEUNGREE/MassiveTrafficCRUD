package com.massive.boardserver.mapper;

import com.massive.boardserver.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
	public int register(PostDTO postDTO);

	public List<PostDTO> selectMyProducts(int accountId);

	public void updateProducts(PostDTO postDTO);

	public void deleteProduct(int productId);
}