package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.api.request.UserHistoryRegisterReq;
import com.ssafy.db.entity.UserHistory;

/**
 * 회원 히스토리 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long>{
	Optional<UserHistory> findById(Long id);
	List<UserHistory> findByUserId(Long userId);
	void deleteById(Long id);

}
