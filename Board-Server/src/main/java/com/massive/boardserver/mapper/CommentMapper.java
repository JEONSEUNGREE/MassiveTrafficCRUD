package com.massive.boardserver.mapper;

import com.massive.boardserver.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
	public int register(CommentDTO commentDTO);

	public void updateComments(CommentDTO commentDTO);

	public void deletePostComment(int commentId);
}