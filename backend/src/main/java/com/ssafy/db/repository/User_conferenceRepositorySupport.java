package com.ssafy.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class User_conferenceRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
//	QUser_conference qUser_conference = QUser_conference.user_conference;
}
