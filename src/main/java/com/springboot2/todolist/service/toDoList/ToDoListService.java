package com.springboot2.todolist.service.toDoList;

import java.util.List;

import com.springboot2.todolist.web.dto.toDoList.CreateToDoListReqDto;
import com.springboot2.todolist.web.dto.toDoList.CreateToDoListRespDto;

//CRUD
public interface ToDoListService {
	public CreateToDoListRespDto createToDoList(CreateToDoListReqDto createToDoListReqRepository) throws Exception;
	public boolean readToDoList() throws Exception;
	public List<CreateToDoListRespDto> getToDoList(int page) throws Exception;
	public CreateToDoListRespDto updateToDoList(int contentcode, CreateToDoListReqDto createToDoListReqDto) throws Exception;
	public boolean deleteToDoList() throws Exception;
}
