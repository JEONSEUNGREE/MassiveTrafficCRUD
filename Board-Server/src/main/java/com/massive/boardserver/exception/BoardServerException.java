package com.massive.boardserver.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardServerException extends RuntimeException {
	HttpStatus code;
	String msg;
}
