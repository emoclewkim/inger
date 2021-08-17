package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.TodoList;
import com.ssafy.db.entity.TodoListDetail;

@Repository
public interface TodoListDetailRepository extends JpaRepository<TodoListDetail, Long> {

	Optional<List<TodoListDetail>> findByTodoList(TodoList todoList);

	Integer countByTodoList(TodoList todoList);

}
