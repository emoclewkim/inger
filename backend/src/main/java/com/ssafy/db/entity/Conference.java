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
	@JoinColumn(name = "owner_id", nullable = false)
	User user;

	@ManyToOne
	@JoinColumn(name = "category", nullable = false)
	Category category;

	Timestamp call_start_time;
	Timestamp call_end_time;
	String thumbnail_url;
	String title;
	String description;
	Boolean is_active;
}
