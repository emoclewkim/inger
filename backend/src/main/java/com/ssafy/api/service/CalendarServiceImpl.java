package com.ssafy.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.CalendarRegisterReq;
import com.ssafy.api.request.CalendarUpdateReq;
import com.ssafy.db.entity.Calendar;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;

/**
 * 캘린더 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("calendarService")
@RequiredArgsConstructor
public class CalendarServiceImpl implements CalendarService {

	@Autowired
	CalendarRepository calendarRepository;

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
	public List<Calendar> getCalendarByUserId(Long id) {
		List<Calendar> calendar = calendarRepository.findByUserId(id);
		return calendar;
	}

	@Override
	@Transactional
	public Calendar modifyCalendar(Long id, CalendarUpdateReq calendarUpdateReq) {
		Calendar calendar = calendarRepository.findById(id).get();
		
		calendar.setPromise(calendarUpdateReq.getPromise());
		calendar.setDiary(calendarUpdateReq.getDiary());
		return calendar;

	}

	@Override
	public void deleteCalendarById(Long id) {
		calendarRepository.deleteById(id);
	}

}
