package com.learn.security.repository;

import com.learn.security.entity.KeyPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyPointRepository extends JpaRepository<KeyPoint, Long> {
    // Custom query methods, if needed
}