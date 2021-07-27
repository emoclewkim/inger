package com.ssafy.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.CalendarRegisterReq;
import com.ssafy.api.request.CalendarRegisterUpdateReq;
import com.ssafy.db.entity.Calendar;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.CalendarRepository;
import com.ssafy.db.repository.CalendarRepositorySupport;

import lombok.RequiredArgsConstructor;

/**
 * 캘린더 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("calendarService")
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	CalendarRepository calendarRepository;
	
	@Autowired
	CalendarRepositorySupport calendarRepositorySupport;
	
	@Override
	public Optional<Calendar> createCalendar(CalendarRegisterReq calendarRegisterReq) {
		Calendar calendar = new Calendar();
		User user = new User();
		user.setId(calendarRegisterReq.getUserId());
		calendar.setUser(user);
		calendar.setDate(calendarRegisterReq.getDate());
		calendar.setPromise(calendarRegisterReq.getPromise());
		calendar.setDiary(calendarRegisterReq.getDiary());
		return Optional.ofNullable(calendarRepository.save(calendar));
	}

	@Override
	public Optional<Calendar> getCalendarByUserId(Long userId) {
		Optional<Calendar> calendar = calendarRepositorySupport.findCalendarByUserId(userId);
		return calendar;
	}

	@Override
	public Calendar updateCalendarByUserId(Long userId, CalendarRegisterUpdateReq registerInfo) {
		return null;
	//	Calendar calendar = calendarRepository.findCalendarByUserId(userId);
		
	}

}
