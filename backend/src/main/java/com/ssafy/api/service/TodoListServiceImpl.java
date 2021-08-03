package com.ssafy.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.TodoListDetailRegisterReq;
import com.ssafy.api.request.TodoListDetailRegisterUpdateReq;
import com.ssafy.api.request.TodoListRegisterReq;
import com.ssafy.api.request.TodoListRegisterUpdateReq;
import com.ssafy.api.response.TodoListDetailRes;
import com.ssafy.api.response.TodoListRes;
import com.ssafy.db.entity.TodoList;
import com.ssafy.db.entity.TodoListDetail;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.TodoListDetailRepository;
import com.ssafy.db.repository.TodoListRepository;
import com.ssafy.db.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 * todoList 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("todoListService")
@RequiredArgsConstructor
public class TodoListServiceImpl implements TodoListService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	TodoListRepository todoListRepository;

	@Autowired
	TodoListDetailRepository todoListDetailRepository;

	@Override
	public List<TodoListRes> selectTodoListList(Long userId) {
		Optional<List<TodoList>> todoList = todoListRepository.findByUserId(userId);
		List<TodoListRes> list = new ArrayList<TodoListRes>();
		if (todoList.isPresent()) {
			for (TodoList todo : todoList.get()) {
				TodoListRes res = new TodoListRes();
				res.setId(todo.getId());
				res.setUserId(todo.getUser().getId());
				res.setDate(todo.getDate());
				res.setTodoindex(todo.getTodoindex());
				res.setTodo(todo.getTodo());
				res.setIsFinish(todo.getIsFinish());
				res.setDetail(selectTodoListDetailList(res.getId()));
				list.add(res);
			}
		}
		return list;
	}

	@Override
	public TodoList createTodoList(TodoListRegisterReq todoListRegisterReq) {
		Optional<User> user = userRepository.findById(todoListRegisterReq.getUserId());
		if (!user.isPresent()) {
			return null;
		}

		TodoList todoList = new TodoList();
		todoList.setUser(user.get());
		todoList.setDate(todoListRegisterReq.getDate());
		todoList.setTodo(todoListRegisterReq.getTodo());
		todoList.setTodoindex(todoListRegisterReq.getTodoindex());
		todoList.setIsFinish(false);
		return todoListRepository.save(todoList);
	}

	@Override
	@Transactional
	public TodoList updateTodoList(TodoListRegisterUpdateReq todoListRegisterUpdateReq) {
		TodoList todoList = todoListRepository.findById(todoListRegisterUpdateReq.getId()).get();
		todoList.setTodoindex(todoListRegisterUpdateReq.getTodoindex());
		todoList.setTodo(todoListRegisterUpdateReq.getTodo());
		todoList.setIsFinish(todoListRegisterUpdateReq.getIsFinish());
		
		return todoList;
	}

	@Override
	public void deleteTodoList(Long id) {
		todoListRepository.deleteById(id);
	}

	@Override
	public List<TodoListDetailRes> selectTodoListDetailList(Long todoId) {
		try {
			TodoList todoList = todoListRepository.findById(todoId).get();
			Optional<List<TodoListDetail>> list = todoListDetailRepository.findByTodoList(todoList);
			List<TodoListDetailRes> detail = new ArrayList<TodoListDetailRes>();
			if (list.isPresent()) {
				List<TodoListDetail> getList = list.get();
				for (TodoListDetail todoListDetail : getList) {
					TodoListDetailRes res = new TodoListDetailRes();
					res.setId(todoListDetail.getId());
					res.setDetailindex(todoListDetail.getDetailindex());
					res.setDetail(todoListDetail.getDetail());
					res.setIsFinish(todoListDetail.getIsFinish());
					detail.add(res);
				}
			}
			return detail;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TodoListDetail createDetail(TodoListDetailRegisterReq todoListDetailRegisterReq) {
		Optional<TodoList> todoList = todoListRepository.findById(todoListDetailRegisterReq.getTodoId());
		if (!todoList.isPresent()) {
			return null;
		}

		TodoListDetail todoListDetail = new TodoListDetail();
		todoListDetail.setTodoList(todoList.get());
		todoListDetail.setDetailindex(todoListDetailRegisterReq.getDetailindex());
		todoListDetail.setDetail(todoListDetailRegisterReq.getDetail());
		todoListDetail.setIsFinish(false);
		return todoListDetailRepository.save(todoListDetail);
	}

	@Override
	@Transactional
	public TodoListDetail updateDetail(TodoListDetailRegisterUpdateReq todoListDetailRegisterUpdateReq) {
		TodoListDetail todoListDetail = todoListDetailRepository.findById(todoListDetailRegisterUpdateReq.getId())
				.get();
		todoListDetail.setDetailindex(todoListDetailRegisterUpdateReq.getDetailindex());
		todoListDetail.setDetail(todoListDetailRegisterUpdateReq.getDetail());
		todoListDetail.setIsFinish(todoListDetailRegisterUpdateReq.getIsFinish());

		return todoListDetail;
	}

	@Override
	public void deleteDetail(Long id) {
		todoListDetailRepository.deleteById(id);
	}

}
