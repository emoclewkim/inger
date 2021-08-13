package com.ssafy.api.service;

import java.util.Optional;

import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.db.entity.Conference;

/**
 *	공부방 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface ConferenceService {
	//공부방 생성
	String createConference(Long userId, Integer category);
	
	//공부방 조회시 카테고리에 해당되는 방을 넘겨준다
	String getConference(Long userId, Integer category);
	
	// userId로 공부방 조회시 현재 회원이 들어가있는 방의 정보를 넘겨준다.
	Optional<Conference> getConferenceBySession(UserHistoryRegisterReq registerInfo);
	
	//공부방 종료시 nowpeople이 1명 초과면 nowpeople--; 1명이면 현재시간을   end date,time에 입력
	//해당 user의 userhistory에도 퇴장시간 입력
	void exitConference(Long userId, String sessionName);
	
//	//개인이 기존에 있던 공부방에 입장 퇴장 할때 호출
//	Conference modifyConference(Long id, Boolean isEnter);
//	
//	//공부방이 종료되는 시간을 작성
//	Conference EndConference(Long id, ConferenceRegisterReq conferenceRegisterReq);
	
}
