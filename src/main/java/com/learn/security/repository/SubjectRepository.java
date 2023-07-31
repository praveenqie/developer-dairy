package com.learn.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.security.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{
	
	

}
