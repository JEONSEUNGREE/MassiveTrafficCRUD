package com.massive.boardserver.service;

import com.massive.boardserver.dto.CategoryDTO;

public interface CategoryService {

	void register(String accountId, CategoryDTO categoryDTO);

	void update(CategoryDTO categoryDTO);

	void delete(int categoryId);
}