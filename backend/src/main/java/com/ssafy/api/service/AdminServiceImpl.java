package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.api.request.AdminRegisterUpdateReq;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

import lombok.RequiredArgsConstructor;

/**
 *	관리자 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("adminService")
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepositorySupport userRepositorySupport;
	
	@Override
	@Transactional
	public User updateUserByKakaoIdnum(AdminRegisterUpdateReq adminRegisterUpdateReq) {
		// TODO Auto-generated method stub
		return null;
	}

}
