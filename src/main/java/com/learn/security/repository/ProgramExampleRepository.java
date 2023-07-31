package com.learn.security.repository;

import com.learn.security.entity.ProgramExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramExampleRepository extends JpaRepository<ProgramExample, Long> {
    // Custom query methods, if needed
}