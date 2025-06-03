package com.massive.boardserver.dto.response;

import com.massive.boardserver.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
	private UserDTO userDTO;
}