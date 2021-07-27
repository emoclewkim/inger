package com.ssafy.db.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Calendar;
import com.ssafy.db.entity.QCalendar;
import com.ssafy.db.entity.QUser;

@Repository
public class CalendarRepositorySupport {
	
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QUser qUser = QUser.user;
	QCalendar qCalendar = QCalendar.calendar;
	
	public Optional<Calendar> findCalendarByUserId(Long userId) {
		Calendar calendar = jpaQueryFactory.select(qCalendar).from(qCalendar).join(qUser).on(qUser.id.eq(userId)).fetchOne();
		if(calendar == null) return Optional.empty();
		return Optional.ofNullable(calendar);
	}
}
