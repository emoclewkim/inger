package com.ssafy.db.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.type.descriptor.sql.SmallIntTypeDescriptor;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Conference_history extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	User user;

	@ManyToOne
	@JoinColumn(name = "conference_id", nullable = false)
	Conference conference;

	SmallIntTypeDescriptor action;
	Timestamp inserted_time;
}
