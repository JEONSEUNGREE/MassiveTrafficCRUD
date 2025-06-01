package com.massive.boardserver.controller;


import com.massive.boardserver.dto.PostDTO;
import com.massive.boardserver.dto.request.PostSearchRequest;
import com.massive.boardserver.service.impl.PostSearchServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@Log4j2
@RequiredArgsConstructor
public class PostSearchController {

	private final PostSearchServiceImpl postSearchService;

	@PostMapping
	public PostSearchResponse search(@RequestBody PostSearchRequest postSearchRequest) {
		List<PostDTO> postDTOList = postSearchService.getProducts(postSearchRequest);
		return new PostSearchResponse(postDTOList);
	}

	@GetMapping
	public PostSearchResponse searchByTagName(String tagName) {
		List<PostDTO> postDTOList = postSearchService.getPostByTag(tagName);
		return new PostSearchResponse(postDTOList);
	}

	// -------------- response 객체 --------------

	@Getter
	@AllArgsConstructor
	private static class PostSearchResponse {
		private List<PostDTO> postDTOList;
	}
}