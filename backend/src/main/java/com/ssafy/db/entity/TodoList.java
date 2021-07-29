package com.ssafy.db.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TodoList extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	User user;
	
	Date date;
	Integer todoindex;
	String todo;
	
	@Column(columnDefinition = "boolean default false")
	Boolean isFinish;
}
