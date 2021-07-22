package com.ssafy.db.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Conference extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	Category category;
	
	int now_people;
	int max_people;
	Timestamp start_room;
	Timestamp end_room;

}
