package com.ssafy.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserConferenceRegisterReq;
import com.ssafy.db.entity.Conference;
import com.ssafy.db.entity.User;
import com.ssafy.db.entity.UserConference;
import com.ssafy.db.repository.ConferenceRepository;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.User_conferenceRepository;

import lombok.RequiredArgsConstructor;

@Service("userConferenceService")
@RequiredArgsConstructor
public class UserConferenceServiceImpl implements UserConferenceService {
	@Autowired
	User_conferenceRepository user_conferenceRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ConferenceRepository conferenceRepository;
	
	@Override
	public Optional<UserConference> createUserConference(UserConferenceRegisterReq userConferenceRegisterReq) {
		UserConference userConference = new UserConference();
		Optional<User> user = userRepository.findById(userConferenceRegisterReq.getUserId());
		Optional<Conference> conference = conferenceRepository.findById(userConferenceRegisterReq.getConferenceId());
		userConference.setUser(user.get());
		userConference.setConference(conference.get());
		return Optional.ofNullable(user_conferenceRepository.save(userConference));
	}

	@Override
	public void deleteUserConference(Long id) {
		user_conferenceRepository.deleteById(id);

	}

}
