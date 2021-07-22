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
public class Todolist extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	User user;

	Date date;
	String todo;
	Boolean is_finish;
}
