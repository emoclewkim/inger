package com.ssafy.api.service;

import java.util.Optional;

import com.ssafy.api.request.TimerRegisterReq;
import com.ssafy.api.response.TimerRes;
import com.ssafy.db.entity.Calendar;

/**
 * 타이머 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface TimerService {

	TimerRes selectTimer(Long id);
	
	Optional<Calendar> createTimer(TimerRegisterReq registerInfo);

	Optional<Calendar> modifyTimer(Long id, TimerRegisterReq registerInfo);
	
}
