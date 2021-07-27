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
public class todoListDetail extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "todoId", nullable = false)
	TodoList todoList;

	String detail;
	Boolean isFinish;
}
