package com.learn.security.repository;

import com.learn.security.entity.SubjectTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTopicRepository extends JpaRepository<SubjectTopic, Long> {
    // Custom query methods, if needed
}