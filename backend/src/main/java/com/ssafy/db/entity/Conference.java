package com.ssafy.db.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Conference extends BaseEntity {
	Integer category;
	String session;
	Integer now_people;
	Integer max_people;
	Date start_room_date;
	Time start_room_time;
	Date end_room_date;
	Time end_room_time;
}
