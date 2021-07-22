package com.ssafy.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
public class User extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	Category category;

	String token;
	String name;
	Integer age;

	@Column(columnDefinition = "boolean default false")
	Boolean is_open;

	@Column(columnDefinition = "boolean default false")
	Boolean is_admin;
}
