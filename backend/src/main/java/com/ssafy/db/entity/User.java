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

	String token; // 카카오톡 API 서비스 연결 토큰
	String name;

	@Column(columnDefinition = "boolean default false")
	Boolean is_open;

	Integer usercode;
	Integer category;
}
