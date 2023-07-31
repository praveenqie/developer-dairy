package com.learn.security.repository;

import com.learn.security.entity.Heading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadingRepository extends JpaRepository<Heading, Long> {
    // Custom query methods, if needed
}