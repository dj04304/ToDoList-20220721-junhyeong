package com.springboot2.todolist.web.dto.toDoList;

import com.springboot2.todolist.domain.toDoList.ToDoList;

import lombok.Data;

@Data
public class CreateToDoListReqDto {
	private String content;
	private int usercode;
	
	public ToDoList toDoEntity() {
		return ToDoList.builder()
				.content(content)
				.usercode(usercode)
				.build();
	}
}
