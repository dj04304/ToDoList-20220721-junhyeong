package com.springboot2.todolist.web.dto.toDoList;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateToDoListRespDto {
	private int contentcode;
	private String cotent;
	private int usercode;
	private String username;
	private LocalDateTime createdate; 
}
