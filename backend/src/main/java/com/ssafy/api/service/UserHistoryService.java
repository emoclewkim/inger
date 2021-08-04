package com.ssafy.api.service;

import java.util.List;
import java.util.Optional;

import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.api.response.UserHistoryRes;
import com.ssafy.db.entity.UserHistory;

/**
 *	회원 히스토리 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface UserHistoryService {
	UserHistoryRes selectUserHistory(Long id);
	Optional<UserHistory> createUserHistory(UserHistoryRegisterReq userHistoryRegisterReq);
	Optional<UserHistory> getUserHistoryById(Long id);
	List<UserHistory> getUserHistoryByUserId(Long userId);
	Optional<UserHistory> UpdateUserHistory(Long id);
	void deleteUserHistoryById(Long id);
}
