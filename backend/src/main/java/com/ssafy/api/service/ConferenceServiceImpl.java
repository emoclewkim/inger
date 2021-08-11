package com.ssafy.api.service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.ConferenceRegisterReq;
import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserHistory;
import com.ssafy.db.repository.ConferenceRepository;
import com.ssafy.db.repository.UserHistoryRepository;

import lombok.RequiredArgsConstructor;

@Service("conferenceService")
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {
	
	@Autowired
	ConferenceRepository conferenceRepository;
	
	@Autowired
	UserHistoryRepository userHistoryRepository;
	
	@Override
	public String createConference(Long userId, Integer category) {
		long now = System.currentTimeMillis();
		Conference conference = new Conference();
		
		// 카테고리에 해당되는 방이 있으면 가져옴
		List<Conference> conferenceList = conferenceRepository.findByCategory(category);
		int size = conferenceList.size()+1;
		
		//랜덤10자리문자 + 카테고리번호 + 해당카테고리에서 몇번째 방인지 카운트수 => sessionName 
		String sessionName = UUID.randomUUID().toString().replace("-", "");
		sessionName =sessionName.substring(0, 10);
		String cat = Integer.toString(category);
		String siz = Integer.toString(size);
		
		System.out.println(sessionName+"   "+cat+"  "+siz);
		sessionName = sessionName+cat+siz;
		//ecd5a3d69f1b4d + category + count
		
		conference.setCategory(category);
		conference.setSession(sessionName);
		conference.setNowPeople(1); // 새로 만들어서 현재인원 1명
		conference.setMaxPeople(6); // 최대인원 6명
		conference.setStartRoomDate(new Date(now));
		conference.setStartRoomTime(new Time(now));
		conferenceRepository.save(conference); //DB에 저장
		
		// UserHistory
		UserHistory userHistory = new UserHistory();
		User user = new User();
		user.setId(userId);
		userHistory.setUser(user);
		userHistory.setConference(conference);
		userHistory.setType(9);
		userHistory.setEnterDate(new Date(now));
		userHistory.setEnterTime(new Time(now));
		userHistoryRepository.save(userHistory);
		
//		conference.setStartRoomTime(conferenceRegisterReq.getStartRoomTime());
//		방을 만들때는 퇴장시간 X
//		conference.setEndRoomDate(conferenceRegisterReq.getEndRoomDate());
//		conference.setEndRoomTime(sqlTime);
//		conference.setEndRoomTime(conferenceRegisterReq.getEndRoomTime());
		return sessionName;
	}

	@Override
	public String getConference(Long userId, Integer category) {
		// 카테고리에 해당되는 방이 있으면 가져옴
		List<Conference> conferenceList = conferenceRepository.findByCategory(category);
		String sessionName=null; // 초기값 null값으로 두고
		long now = System.currentTimeMillis();
		
		for (Conference conference : conferenceList) {
			if(conference.getNowPeople() < 6) { // 리스트에 해당 카테코리에 맞는 6명이하인 공부방이 1개라도 있으면 nowPeople++해주고 해당 공부방의 세션이름을 리턴 
				sessionName = conference.getSession();
				int cnt =conference.getNowPeople();
				conference.setNowPeople(cnt+1); // 인원한명 증가
				conferenceRepository.save(conference); //DB에 저장
				
				// UserHistory
				UserHistory userHistory = new UserHistory();
				User user = new User();
				user.setId(userId);
				userHistory.setUser(user);
				userHistory.setConference(conference);
				userHistory.setType(9);
				userHistory.setEnterDate(new Date(now));
				userHistory.setEnterTime(new Time(now));
				userHistoryRepository.save(userHistory);
				
				
				break;
			}
		}
		return sessionName;
	}

	@Override
	public void exitConference(Long userId, String sessionName) {
		
		
	}

//	@Override
//	@Transactional
//	public Conference modifyConference(Long id, Boolean isEnter) {
//		Conference conference = conferenceRepository.findById(id).get();
//		Integer peopleNum = conference.getNowPeople();
//
//		if(isEnter) { //입장하는거면 +1
//			peopleNum += 1;
//		}else {		//퇴장하는거면 -1
//		peopleNum -= 1;
//		}
//		conference.setNowPeople(peopleNum);	
//		
//		return conference;
//	}
//
//	@Override
//	@Transactional
//	public Conference EndConference(Long id, ConferenceRegisterReq conferenceRegisterReq) {
//		Conference conference = conferenceRepository.findById(id).get();
//		long now = System.currentTimeMillis();
//		//종료되는날짜 시간을 적고 종료
//		conference.setEndRoomDate(new Date(now));
//		conference.setEndRoomTime(new Time(now));		
//		return conference;
//	}

}
