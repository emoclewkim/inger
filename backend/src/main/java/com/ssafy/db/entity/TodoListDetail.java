package com.ssafy.db.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TodoListDetail extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "todoId", nullable = false)
	TodoList todoList;

	Integer detailindex;
	String detail;
	Boolean isFinish;
}
