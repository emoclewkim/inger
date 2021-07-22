package com.ssafy.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.db.entity.Category;
import java.util.Optional;

@Repository
public interface Conference_categoryRepository extends JpaRepository<Category, Long> {

}
