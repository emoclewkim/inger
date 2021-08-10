package com.ssafy.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.request.UserUpdateReq;
import com.ssafy.api.response.UserRegistRes;
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
	public UserRegistRes selectUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		UserRegistRes res = new UserRegistRes();
		res.setMessage("Success");
		res.setId(user.get().getId());
		res.setKakaoIdNum(user.get().getKakaoIdNum());
		res.setName(user.get().getName());
		res.setIsOpen(user.get().getIsOpen());
		res.setUsercode(user.get().getUsercode());
		res.setCategory(user.get().getCategory());
		return res;		
	}
	
	@Override
	public User createUser(UserRegisterPostReq userRegisterPostReq) {
		User user = new User();
		user.setKakaoIdNum(userRegisterPostReq.getKakaoIdNum());
		user.setName(userRegisterPostReq.getName());
		user.setIsOpen(userRegisterPostReq.getIsOpen());
		user.setUsercode(101); // 기본값으로 일반 회원 코드 사용
		user.setCategory(userRegisterPostReq.getCategory());
		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserByKakaoIdNum(String kakaoIdNum) {
		// 디비에 유저 정보 조회 (kakaoIdNum 를 통한 조회).
		Optional<User> user = userRepositorySupport.findUserByKakaoIdNum(kakaoIdNum);
		return user;
	}

	@Override
	@Transactional
	public User updateUserByKakaoIdNum(String kakaoIdNum, UserUpdateReq registerInfo) {
		User user = userRepository.findByKakaoIdNum(kakaoIdNum).get();

		if (user.getId() == null) {
			return null;
		}
		user.setCategory(registerInfo.getCategory());
		user.setIsOpen(registerInfo.getIsOpen());
		user.setName(registerInfo.getName());
		return user;
	}

	@Override
	public Optional<User> getUserByName(String name) {
		Optional<User> user = userRepository.findByName(name);
		return user;
	}
	

	@Override
	@Transactional
	public void deleteUserByKakaoIdNum(String kakaoIdNum) {
		userRepository.deleteByKakaoIdNum(kakaoIdNum);
	}

	@Override
	public Optional<User> checkUserByName(String name) {
		Optional<User> user = userRepository.findByName(name);
		return user;
	}

	@Override
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user;
	}
	
}
