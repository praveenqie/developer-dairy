package com.learn.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.learn.security.entity.Subject;

@Service
public interface SubjectService {

	Subject getSubjectById(Long subjectId);

	List<Subject> getAllSubjects();

	Subject saveSubject(Subject subject);

	void deleteSubject(Long subjectId);
}
