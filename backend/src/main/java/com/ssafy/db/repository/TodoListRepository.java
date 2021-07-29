package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

	Optional<List<TodoList>> findByUserId(Long userId);

}
