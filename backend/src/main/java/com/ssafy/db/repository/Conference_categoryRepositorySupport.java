package com.ssafy.db.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class Conference_categoryRepositorySupport {
	@Autowired
    private JPAQueryFactory jpaQueryFactory;
//	QConference_category qConference_category = QConference_category.conference_category;

}
