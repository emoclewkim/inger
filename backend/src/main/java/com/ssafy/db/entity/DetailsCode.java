package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DetailsCode{
	@Id
	Long id;
	
	@ManyToOne
	@JoinColumn(name = "type", nullable = false)
	CommonCode commonCode;
	
	String name;
}
