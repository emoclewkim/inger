package com.ssafy.api.service;

import java.util.Optional;

import com.ssafy.api.request.UserConferenceRegisterReq;
import com.ssafy.db.entity.UserConference;

public interface UserConferenceService {
	Optional<UserConference> createUserConference(UserConferenceRegisterReq userConferenceRegisterReq);
	void deleteUserConference(Long id);
	
}
