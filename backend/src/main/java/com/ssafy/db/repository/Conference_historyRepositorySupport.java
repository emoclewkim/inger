package com.ssafy.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class Conference_historyRepositorySupport {
	@Autowired
    private JPAQueryFactory jpaQueryFactory;
//	QConference_history qConference_history = QConference_history.conference_history;
}
