package com.ssafy.api.service;

import java.util.List;
import java.util.Optional;

import com.ssafy.api.request.CalendarRegisterReq;
import com.ssafy.api.request.CalendarUpdateReq;
import com.ssafy.db.entity.Calendar;

/**
 *	캘린더 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface CalendarService {
	
	Optional<Calendar> createCalendar(CalendarRegisterReq calendarRegisterReq);
	List<Calendar> getCalendarByUserId(Long userId);
	Calendar modifyCalendar(Long id, CalendarUpdateReq calendarUpdateReq);
	void deleteCalendarById(Long id);
}
