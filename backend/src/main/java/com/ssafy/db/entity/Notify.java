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
public class Notify extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	User user;

	Date notifyDate;
	String reason;
	Integer handling;
}
