package com.springboot2.todolist.service.toDoList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot2.todolist.domain.toDoList.ToDoList;
import com.springboot2.todolist.domain.toDoList.ToDoListRepository;
import com.springboot2.todolist.web.dto.toDoList.CreateToDoListReqDto;
import com.springboot2.todolist.web.dto.toDoList.CreateToDoListRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoListImplService implements ToDoListService{
	
	private final ToDoListRepository toDoListRepository;

	@Override
	public CreateToDoListRespDto createToDoList(CreateToDoListReqDto createToDoListReqDto) throws Exception {
		ToDoList toDoListEntity = createToDoListReqDto.toDoEntity();
		
		boolean insertStatus = toDoListRepository.save(toDoListEntity) > 0;
		
		return toDoListEntity.toCreateToDoListDto();
	}

	@Override
	public boolean readToDoList() throws Exception {
		
		return false;
	}

		
	@Override
	public List<CreateToDoListRespDto> getToDoList(int page) throws Exception {
		List<CreateToDoListRespDto> toDoListDtoarr = new ArrayList<CreateToDoListRespDto>();
		
		toDoListRepository.getToDoListOfIndex((page - 1) * 10).forEach(list -> {
			toDoListDtoarr.add(list.toReadToDoListDto());
		});
		
		return toDoListDtoarr;
	}
	
	@Override
	public CreateToDoListRespDto updateToDoList(int contentcode, CreateToDoListReqDto createToDoListReqDto) throws Exception {
		ToDoList toDoListEntity = createToDoListReqDto.toDoEntity();
		
		return toDoListEntity.toReadToDoListDto();
	}

	@Override
	public boolean deleteToDoList() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
