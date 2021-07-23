package com.ssafy.db.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User_history extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	User user;

	@ManyToOne
	@JoinColumn(name = "conference_id", nullable = false)
	Conference conference;
	
	int type;
	Date enter_date;
	Time enter_time;
	Date exit_date;
	Time exit_time;
}
