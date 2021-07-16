package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Conference_history;

import java.util.Optional;

@Repository
public interface Conference_historyRepository extends JpaRepository<Conference_history, Long> {

}
