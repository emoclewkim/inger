package com.ssafy.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.ssafy.api.request.TodoListDetailRegisterReq;
import com.ssafy.api.request.TodoListDetailRegisterUpdateReq;
import com.ssafy.api.request.TodoListRegisterReq;
import com.ssafy.api.request.TodoListRegisterUpdateReq;
import com.ssafy.api.response.TodoListDetailRes;
import com.ssafy.api.response.TodoListRes;
import com.ssafy.db.entity.TodoList;
import com.ssafy.db.entity.TodoListDetail;

/**
 * todoList 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface TodoListService {
	List<TodoListRes> selectTodoListList(Long userId);

	TodoList createTodoList(TodoListRegisterReq todoListRegisterReq);

	TodoList updateTodoList(TodoListRegisterUpdateReq todoListRegisterUpdateReq);

	void deleteTodoList(Long id);

	List<TodoListDetailRes> selectTodoListDetailList(Long todoId);

	TodoListDetail createDetail(TodoListDetailRegisterReq todoListDetailRegisterReq);

	TodoListDetail updateDetail(TodoListDetailRegisterUpdateReq todoListDetailRegisterUpdateReq);

	void deleteDetail(Long id);

	Integer countTodoList(Long userId, Date date);

	Integer countDetail(Long todoId);
}
