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
	Integer nowPeople;
	Integer maxPeople;
	Date startRoomDate;
	Time startRoomTime;
	Date endRoomDate;
	Time endRoomTime;
}
