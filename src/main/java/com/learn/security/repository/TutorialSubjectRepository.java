package com.learn.security.repository;

import com.learn.security.entity.TutorialSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialSubjectRepository extends JpaRepository<TutorialSubject, Long> {
    // Custom query methods, if needed
}