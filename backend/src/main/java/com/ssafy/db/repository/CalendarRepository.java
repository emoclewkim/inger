package com.ssafy.db.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Calendar;

/**
 * 캘린더 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
	List<Calendar> findByUserId(Long userId);

	Optional<Calendar> findById(Long id);

	void deleteById(Long id);

	Calendar findByUserIdAndDate(Long userId, Date date);
}
