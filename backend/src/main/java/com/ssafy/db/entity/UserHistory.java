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
public class UserHistory extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	User user;

	@ManyToOne
	@JoinColumn(name = "conferenceId", nullable = false)
	Conference conference;
	
	Integer type;
	Date enterDate;
	Time enterTime;
	Date exitDate;
	Time exitTime;
}
