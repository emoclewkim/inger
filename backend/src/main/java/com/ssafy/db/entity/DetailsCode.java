package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DetailsCode extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "type", nullable = false)
	CommonCode commonCode;
	
	String name;
}
