package com.ssafy.api.service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.TimerRegisterReq;
import com.ssafy.api.response.TimerRes;
import com.ssafy.db.entity.Calendar;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.CalendarRepository;

import lombok.RequiredArgsConstructor;

/**
 * 타이머 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("timerService")
@RequiredArgsConstructor
public class TimerServiceImpl implements TimerService {
	
	@Autowired
	CalendarRepository calendarRepository;
	
	@Override
	public TimerRes selectTimer(Long id) {
		Optional<Calendar> calendar = calendarRepository.findById(id);
		TimerRes res = new TimerRes();
		res.setId(calendar.get().getId());
		res.setUserid(calendar.get().getUser().getId());
		res.setDate(calendar.get().getDate());
		res.setStudyTime(calendar.get().getStudyTime());
		return res;
	}

	@Override
	public Optional<Calendar> createTimer(TimerRegisterReq registerInfo) {
		Calendar calendar = new Calendar();
		User user = new User();
		user.setId(registerInfo.getUserId());
		calendar.setUser(user);
		calendar.setDate(registerInfo.getDate());
		calendar.setStudyTime(registerInfo.getStudyTime());
		return Optional.ofNullable(calendarRepository.save(calendar));
	}

	@Override
	@Transactional
	public Optional<Calendar> modifyTimer(Long id, TimerRegisterReq registerInfo) {
		Calendar calendar = calendarRepository.findById(id).get();
		calendar.setStudyTime(registerInfo.getStudyTime());
		return Optional.ofNullable(calendar);
	}

	
}
