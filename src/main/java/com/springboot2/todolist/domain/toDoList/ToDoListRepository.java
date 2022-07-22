package com.springboot2.todolist.domain.toDoList;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ToDoListRepository {

	public int save(ToDoList toDoList);
	public List<ToDoList> getToDoListOfIndex(int index);
	public void updateToDoList(ToDoList todoList);
}
