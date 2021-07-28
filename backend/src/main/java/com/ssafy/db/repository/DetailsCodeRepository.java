package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.db.entity.CommonCode;
import com.ssafy.db.entity.DetailsCode;

public interface DetailsCodeRepository extends JpaRepository<DetailsCode, Long>{
	
	Optional<List<DetailsCode>> findByCommonCode(CommonCode commonCode);

}
