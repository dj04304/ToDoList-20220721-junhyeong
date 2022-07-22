package com.springboot2.todolist.domain.toDoList;

import java.time.LocalDateTime;

import com.springboot2.todolist.web.dto.toDoList.CreateToDoListRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoList {
	private int contentcode;
	private String content;
	private int usercode;
	private String username;
	private LocalDateTime createdate;
	private LocalDateTime updatedate;
	
	public CreateToDoListRespDto toCreateToDoListDto() {
		return CreateToDoListRespDto.builder()
				.contentcode(contentcode)
				.cotent(content)
				.usercode(usercode)
				.build();
	}
	
	public CreateToDoListRespDto toReadToDoListDto() {
		return CreateToDoListRespDto.builder()
				.contentcode(contentcode)
				.cotent(content)
				.usercode(usercode)
				.createdate(createdate)
				.build();
				
	}
	
}
