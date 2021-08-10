package com.ssafy.api.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.CalendarRegisterReq;
import com.ssafy.api.response.CalendarRes;
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
		calendar.setStudyTime(0);
		return Optional.ofNullable(calendarRepository.save(calendar));
	}

	@Override
	public List<Calendar> getCalendarByUserId(Long id) {
		List<Calendar> calendar = calendarRepository.findByUserId(id);
		return calendar;
	}

	@Override
	public Optional<Calendar> getCalendarByUserIdAndDate(Long userId, Date date) {
		Calendar calendar = calendarRepository.findByUserIdAndDate(userId, date);
		return Optional.ofNullable(calendar);
	}

	@Override
	@Transactional
	public Optional<Calendar> modifyCalendar(Long id, CalendarRegisterReq calendarRegisterReq) {
		Calendar calendar = calendarRepository.findById(id).get();
		calendar.setPromise(calendarRegisterReq.getPromise());
		calendar.setDiary(calendarRegisterReq.getDiary());
		return Optional.ofNullable(calendar);

	}

	@Override
	public void deleteCalendarById(Long id) {
		calendarRepository.deleteById(id);
	}

	@Override
	public CalendarRes selectCalendar(Long id) {
		Optional<Calendar> calendar = calendarRepository.findById(id);
		CalendarRes res = new CalendarRes();
		res.setId(calendar.get().getId());
		res.setUserid(calendar.get().getUser().getId());
		res.setDate(calendar.get().getDate());
		res.setPromise(calendar.get().getPromise());
		res.setDiary(calendar.get().getDiary());
		res.setStudyTime(calendar.get().getStudyTime());
		
		return res;
	}

}
