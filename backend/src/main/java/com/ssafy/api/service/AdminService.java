package com.ssafy.api.service;

import com.ssafy.api.request.AdminRegisterUpdateReq;
import com.ssafy.db.entity.User;

/**
 *	관리자 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface AdminService {
	User updateUserByKakaoIdnum(AdminRegisterUpdateReq adminRegisterUpdateReq);
}
