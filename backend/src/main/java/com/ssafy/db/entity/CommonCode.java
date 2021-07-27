package com.ssafy.db.entity;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CommonCode extends BaseEntity {
	String kind;
}
