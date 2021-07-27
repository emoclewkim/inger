package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Details_code extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "type", nullable = false)
	Common_code commonCode;
	
	String name;
}
