package com.springboot2.todolist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CMRespDto <T>{
	private int code;
	private String message;
	private T data;
}
