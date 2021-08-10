package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.UserConference;

import java.util.Optional;

@Repository
public interface User_conferenceRepository extends JpaRepository<UserConference, Long> {
}
