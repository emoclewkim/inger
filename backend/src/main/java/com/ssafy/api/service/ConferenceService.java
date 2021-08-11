package com.ssafy.api.service;

import java.util.Optional;

import com.ssafy.api.request.ConferenceRegisterReq;
import com.ssafy.api.request.ConferenceUpdateReq;
import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.db.entity.Conference;

/**
 *	공부방 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface ConferenceService {
	//공부방 생성
	Optional<String> createConference(Long userId, Integer category);
	
	//공부방 조회시 카테고리에 해당되는 방을 넘겨준다
	Optional<String> getConference(Integer category);
	
	//
	
//	//개인이 기존에 있던 공부방에 입장 퇴장 할때 호출
//	Conference modifyConference(Long id, Boolean isEnter);
//	
//	//공부방이 종료되는 시간을 작성
//	Conference EndConference(Long id, ConferenceRegisterReq conferenceRegisterReq);
	
}
