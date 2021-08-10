package com.ssafy.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.TodoListDetailRegisterReq;
import com.ssafy.api.request.TodoListDetailRegisterUpdateReq;
import com.ssafy.api.request.TodoListRegisterReq;
import com.ssafy.api.request.TodoListRegisterUpdateReq;
import com.ssafy.api.response.TodoListDetailRes;
import com.ssafy.api.response.TodoListRes;
import com.ssafy.api.service.TodoListService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.TodoList;
import com.ssafy.db.entity.TodoListDetail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * todoList 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "todoList API", tags = { "TodoList" })
@RestController
@RequestMapping("/api/v1/todoList")
public class TodoListController {
	@Autowired
	TodoListService todoListService;

	@GetMapping("/select/{userId}")
	@ApiOperation(value = "todoList전체검색", notes = "유저의 id값을 기반으로 todoList 검색")
	public ResponseEntity<List<TodoListRes>> getTodoListList(@PathVariable Long userId) {
		List<TodoListRes> todoList = todoListService.selectTodoListList(userId);

		return ResponseEntity.status(200).body(todoList);
	}

	@PostMapping("/create")
	@ApiOperation(value = "todoList생성", notes = "유저의 id값과 date를 기반으로 todoList 생성")
	public ResponseEntity<BaseResponseBody> createTodoList(@RequestBody List<TodoListRegisterReq> todoList) {
		int success = 0;
		int todoIndex = 0;
		int detailIndex = 0;

		for (TodoListRegisterReq req : todoList) {
			todoIndex = todoListService.countTodoList(req.getUserId(), req.getDate()) + 1;
			req.setTodoindex(todoIndex);
			TodoList todoListReq = todoListService.createTodoList(req);
			if (todoListReq != null) {
				detailIndex = todoListService.countDetail(todoListReq.getId()) + 1;
				for (TodoListDetailRegisterReq detailReq : req.getDetail()) {
					detailReq.setTodoId(todoListReq.getId());
					detailReq.setDetailindex(detailIndex);
					TodoListDetail detail = todoListService.createDetail(detailReq);
					detailIndex++;
				}
				success++;
			}
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success " + success));
	}

	@PatchMapping("/update")
	@ApiOperation(value = "todoList수정", notes = "todoList의 id값을 기반으로 데이터 수정")
	public ResponseEntity<BaseResponseBody> updateTodoList(
			@RequestBody List<TodoListRegisterUpdateReq> todoListRegisterUpdateReq) {
		int success = 0;
		for (TodoListRegisterUpdateReq req : todoListRegisterUpdateReq) {
			TodoList todoList = todoListService.updateTodoList(req);
			if (todoList != null) {
				success++;
			}
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success " + success));
	}

	@DeleteMapping("/delete")
	@ApiOperation(value = "todoList삭제", notes = "해당 id값의 todoList 삭제")
	public ResponseEntity<BaseResponseBody> deleteTodoList(@RequestBody List<Long> id) {
		int success = 0;
		for (Long req : id) {
			try {
				todoListService.deleteTodoList(req);
				success++;
			} catch (Exception e) {
				System.out.println("Fail " + req);
			}
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success " + success));
	}

//	@GetMapping("/selectDetail/{todoId}")
//	@ApiOperation(value = "todoListDetail검색", notes = "todoList의 id값을 기반으로 todoListDetail 검색")
//	public ResponseEntity<List<TodoListDetail>> getTodoListDetailList(@PathVariable Long todoId) {
//		try {
//			List<TodoListDetail> list = todoListService.selectTodoListDetailList(todoId).get();
//			return ResponseEntity.status(200).body(list);
//		} catch (Exception e) {
//			return ResponseEntity.status(401).body(null);
//		}
//	}

	@PostMapping("/createDetail")
	@ApiOperation(value = "todoListDetail생성", notes = "todoList의 id값을 가지고 todoListDetail 생성")
	public ResponseEntity<BaseResponseBody> createDetail(
			@RequestBody List<TodoListDetailRegisterReq> todoListDetailRegisterReq) {
		int success = 0;
		int detailIndex = 0;
		for (TodoListDetailRegisterReq req : todoListDetailRegisterReq) {
			detailIndex = todoListService.countDetail(req.getTodoId()) + 1;
			req.setDetailindex(detailIndex);
			TodoListDetail todoListDetail = todoListService.createDetail(req);
			if (todoListDetail != null) {
				success++;
			}
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success " + success));
	}

	@PatchMapping("/updateDetail")
	@ApiOperation(value = "todoListDetail수정", notes = "todoListDetail의 id값을 가지고 todoListDetail 수정")
	public ResponseEntity<BaseResponseBody> updateDteail(
			@RequestBody List<TodoListDetailRegisterUpdateReq> todoListDetailRegisterUpdateReq) {
		int success = 0;
		for (TodoListDetailRegisterUpdateReq req : todoListDetailRegisterUpdateReq) {
			TodoListDetail todoListDetail = todoListService.updateDetail(req);
			if (todoListDetail != null) {
				success++;
			}
		}

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success " + success));
	}

	@DeleteMapping("/deleteDetail")
	@ApiOperation(value = "todoListDetail삭제", notes = "해당 id값의 todoListDetail을 삭제")
	public ResponseEntity<BaseResponseBody> deleteDetail(@RequestBody List<Long> id) {
		int success = 0;
		for (Long req : id) {
			try {
				todoListService.deleteDetail(req);
				success++;
			} catch (Exception e) {
				System.out.println("Fail " + req);
			}
		}
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success " + success));
	}
}
