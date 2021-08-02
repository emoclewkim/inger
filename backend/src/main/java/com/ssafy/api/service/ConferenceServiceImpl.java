package com.ssafy.api.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.ConferenceRegisterReq;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.repository.ConferenceRepository;

import lombok.RequiredArgsConstructor;

@Service("conferenceService")
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {
	
	@Autowired
	ConferenceRepository conferenceRepository;
	
	@Override
	public Optional<Conference> createConference(ConferenceRegisterReq conferenceRegisterReq) {
		long now = System.currentTimeMillis();
		Conference conference = new Conference();
		conference.setCategory(conferenceRegisterReq.getCategory());
		conference.setSession(conferenceRegisterReq.getSession());
		conference.setNowPeople(conferenceRegisterReq.getNowPeople());
		conference.setMaxPeople(conferenceRegisterReq.getMaxPeople());
		
		conference.setStartRoomDate(new Date(now));
		conference.setStartRoomTime(new Time(now));
//		conference.setStartRoomTime(conferenceRegisterReq.getStartRoomTime());
//		방을 만들때는 퇴장시간 X
//		conference.setEndRoomDate(conferenceRegisterReq.getEndRoomDate());
//		conference.setEndRoomTime(sqlTime);
//		conference.setEndRoomTime(conferenceRegisterReq.getEndRoomTime());
		return Optional.ofNullable(conferenceRepository.save(conference));
	}

	@Override
	public Optional<Conference> getConference(Integer category) {
		// 카테고리에 해당되는 방이 있으면 가져옴
		Conference conference = conferenceRepository.findByCategory(category);
		return Optional.ofNullable(conference);
	}

	@Override
	@Transactional
	public Conference modifyConference(Long id, Boolean isEnter) {
		Conference conference = conferenceRepository.findById(id).get();
		Integer peopleNum = conference.getNowPeople();

		if(isEnter) { //입장하는거면 +1
			peopleNum += 1;
		}else {		//퇴장하는거면 -1
		peopleNum -= 1;
		}
		conference.setNowPeople(peopleNum);	
		
		return conference;
	}

	@Override
	@Transactional
	public Conference EndConference(Long id, ConferenceRegisterReq conferenceRegisterReq) {
		Conference conference = conferenceRepository.findById(id).get();
		long now = System.currentTimeMillis();
		//종료되는날짜 시간을 적고 종료
		conference.setEndRoomDate(new Date(now));
		conference.setEndRoomTime(new Time(now));		
		return conference;
	}

}
