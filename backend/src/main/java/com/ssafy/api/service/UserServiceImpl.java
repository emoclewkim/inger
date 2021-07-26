package com.ssafy.api.service;

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
//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	UserRepositorySupport userRepositorySupport;
//
////	@Autowired
////	PasswordEncoder passwordEncoder;
//
//	@Override
//	public User createUser(UserRegisterPostReq userRegisterInfo) {
//		User user = new User();
//		user.setKakaoIdNum(userRegisterInfo.getKakaoIdNum());
//		user.setName(userRegisterInfo.getName());
//		user.setIsOpen(userRegisterInfo.getIsOpen());
//		user.setUsercode(userRegisterInfo.getUsercode());
//		user.setCategory(userRegisterInfo.getCategory());
////		user.setUserId(userRegisterInfo.getId());
////		// 보안을 위해서 유저 패스워드 암호화 하여 디비에 저장.
////		user.setPassword(passwordEncoder.encode(userRegisterInfo.getPassword()));
////		user.setDepartment(userRegisterInfo.getDepartment());
////		user.setName(userRegisterInfo.getName());
////		user.setPosition(userRegisterInfo.getPosition());
//		return userRepository.save(user);
//	}
//
//	@Override
//	public User getUserByKakao_idnum(String kakao_idnum) {
//		// 디비에 유저 정보 조회 (userId 를 통한 조회).
//		User user = userRepositorySupport.findUserByKakao_idnum(kakao_idnum).get();
//
//		return user;
//	}
//
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
