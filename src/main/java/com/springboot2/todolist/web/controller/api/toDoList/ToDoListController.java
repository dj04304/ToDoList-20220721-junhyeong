package com.springboot2.todolist.web.controller.api.toDoList;

import java.util.List;

import org.apache.ibatis.annotations.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot2.todolist.service.toDoList.ToDoListService;
import com.springboot2.todolist.web.dto.CMRespDto;
import com.springboot2.todolist.web.dto.toDoList.CreateToDoListReqDto;
import com.springboot2.todolist.web.dto.toDoList.CreateToDoListRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class ToDoListController {

	private final ToDoListService toDoListService;
	
	//todolist 생성
	
	@PostMapping("/content")
	public ResponseEntity<?> addToDoList(@RequestBody CreateToDoListReqDto createToDoListReqDto) {
		CreateToDoListRespDto createToDoListRespDto = null;
		
		try {
			createToDoListRespDto = toDoListService.createToDoList(createToDoListReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(1, "todolist 생성 실패", createToDoListRespDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "todolist생성 성공", createToDoListRespDto));
	}
	
	//todolist 조회
	@GetMapping("/list")
	public ResponseEntity<?> getToDoListPage(@RequestParam int page){
		List<CreateToDoListRespDto> toDoListarry = null;
		
		try {
			toDoListarry = toDoListService.getToDoList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "todolist 리스트" + page + "페이지 불러오기 실패", toDoListarry));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "todolist 리스트" + page + "페이지 불러오기 성공", toDoListarry));
	}
	
	//todolist 수정
	@PutMapping("/update")
	public ResponseEntity<?> changeToDoList(@RequestParam int contentcode, CreateToDoListReqDto createToDoListReqDto){
		CreateToDoListRespDto createToDoListRespDto = null;
		
		try {
			createToDoListRespDto = toDoListService.updateToDoList(contentcode, createToDoListReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "todolist 수정 실패", createToDoListRespDto));
		}
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "todolist 수정 성공", createToDoListRespDto));
	}
	
}
