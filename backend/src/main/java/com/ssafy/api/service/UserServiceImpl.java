package com.ssafy.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.request.UserRegisterUpdateReq;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

import lombok.RequiredArgsConstructor;

/**
 * 유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRepositorySupport userRepositorySupport;

	@Override
	public User createUser(String kakaoIdNum) {
		User user = new User();
		user.setKakaoIdNum(kakaoIdNum);
		user.setName("1234");
		user.setIsOpen(false);
		user.setUsercode(101);
		user.setCategory(101);
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserByKakaoIdNum(String kakaoIdNum) {
		// 디비에 유저 정보 조회 (kakaoIdNum 를 통한 조회).
		Optional<User> user = userRepositorySupport.findUserByKakaoIdNum(kakaoIdNum);
		System.out.println("userService Impl : " + user);
		return user;
	}

//	@Override
//	@Transactional
//	public User updateUserByKakao_idnum(String kakao_idnum, UserRegisterUpdateReq registerInfo) {
//		User user = userRepository.findByKakao_idnum(kakao_idnum).get();
//		
//		if (user.getId() == null) {
//			return null;
//		}
//
//		user.setDepartment(registerInfo.getDepartment());
//		user.setPosition(registerInfo.getPosition());
//		user.setName(registerInfo.getName());
//		return user;
//	}

}
