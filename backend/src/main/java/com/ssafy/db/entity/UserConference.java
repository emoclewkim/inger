package com.ssafy.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserConference extends BaseEntity{
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	User user;

	@ManyToOne
	@JoinColumn(name = "conferenceId", nullable = false)
	Conference conference;
}
