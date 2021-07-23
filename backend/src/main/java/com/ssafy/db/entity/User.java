package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
public class User extends BaseEntity {

	String token;
	String name;
	
	@Column(columnDefinition = "boolean default false")
	Boolean is_open;

	@Column(columnDefinition = "boolean default false")
	Boolean is_admin;
	
	int usercode;
	int category;
}
