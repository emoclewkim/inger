package com.ssafy.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.ssafy.api.request.CalendarRegisterReq;
import com.ssafy.api.response.CalendarRes;
import com.ssafy.db.entity.Calendar;

/**
 * 캘린더 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface CalendarService {

	CalendarRes selectCalendar(Long id);
	
	Optional<Calendar> createCalendar(CalendarRegisterReq calendarRegisterReq);
	
	List<Calendar> getCalendarByUserId(Long userId);

	Optional<Calendar> getCalendarByUserIdAndDate(Long userId, Date date);

	Optional<Calendar> modifyCalendar(Long id, CalendarRegisterReq calendarRegisterReq);

	void deleteCalendarById(Long id);
}
