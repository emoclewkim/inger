package com.ssafy.api.service;

import java.util.Optional;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.request.UserRegisterUpdateReq;
import com.ssafy.db.entity.User;

/**
 * 유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */

public interface UserService {

	Optional<User> createUser(UserRegisterPostReq userRegisterPostReq);

	Optional<User> getUserByKakaoIdNum(String kakaoIdNum);

	Optional<User> checkUserByName(String name);
	
	User updateUserByKakaoIdNum(String kakaoIdNum, UserRegisterUpdateReq registerInfo);

	Optional<User> getUserByName(String name);
	
	void deleteUserByKakaoIdNum(String kakaoIdNum);
}
