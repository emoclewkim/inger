package com.ssafy.api.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.api.response.UserHistoryRes;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserHistory;
import com.ssafy.db.repository.UserHistoryRepository;

import lombok.RequiredArgsConstructor;

@Service("userHistoryService")
@RequiredArgsConstructor
public class UserHistoryServiceImpl implements UserHistoryService {
	
	@Autowired
	UserHistoryRepository userHistoryRepository;
	
	@Override
	public UserHistoryRes selectUserHistory(Long id) {
		Optional<UserHistory> userHistory = userHistoryRepository.findById(id);
		UserHistoryRes res = new UserHistoryRes();
		res.setId(userHistory.get().getId());
		res.setUserid(userHistory.get().getUser().getId());
		res.setConferenceid(userHistory.get().getConference().getId());
		res.setType(userHistory.get().getType());;
		res.setEnterDate(userHistory.get().getEnterDate());
		res.setEnterTime(userHistory.get().getEnterTime());
		res.setExitDate(userHistory.get().getExitDate());
		res.setExitTime(userHistory.get().getExitTime());
		
		return res;
	}
	
	@Override
	public Optional<UserHistory> createUserHistory(UserHistoryRegisterReq userHistoryRegisterReq) {
		long now = System.currentTimeMillis();
		UserHistory userHistory = new UserHistory();
		User user = new User();
		user.setId(userHistoryRegisterReq.getUserId());
		userHistory.setUser(user);
		
		Conference conference = new Conference();
		conference.setId(userHistoryRegisterReq.getConferenceId());
		userHistory.setConference(conference);
		
		userHistory.setType(userHistoryRegisterReq.getType());
		userHistory.setEnterDate(new Date(now));
		userHistory.setEnterTime(new Time(now));
		return Optional.ofNullable(userHistoryRepository.save(userHistory));
	}

	@Override
	public Optional<UserHistory> getUserHistoryById(Long id) {
		Optional<UserHistory> userHistory = userHistoryRepository.findById(id);
		return userHistory;
	}
	

	@Override
	public List<UserHistory> getUserHistoryByUserId(Long userId) {
		List<UserHistory> userHistory = userHistoryRepository.findByUserId(userId);
		return userHistory;
	}

	@Override
	@Transactional
	public Optional<UserHistory> UpdateUserHistory(Long id) {
		UserHistory userHistory = userHistoryRepository.findById(id).get();
		if(userHistory.getId() == null) {
			return null;
		}
		
		long now = System.currentTimeMillis();
		userHistory.setExitDate(new Date(now));
		userHistory.setExitTime(new Time(now));
		return Optional.ofNullable(userHistory);	
	}

	@Override
	@Transactional
	public void deleteUserHistoryById(Long id) {
		userHistoryRepository.deleteById(id);
		
	}

}
