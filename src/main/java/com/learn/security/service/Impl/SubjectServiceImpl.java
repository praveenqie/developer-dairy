package com.learn.security.service.Impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.security.entity.Subject;
import com.learn.security.repository.SubjectRepository;
import com.learn.security.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	private final SubjectRepository subjectRepository;

	@Autowired
	public SubjectServiceImpl(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	@Override
	public Subject getSubjectById(Long subjectId) {
		return subjectRepository.findById(subjectId).orElse(null);
	}

	@Override
	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}
	@Override
	public Subject saveSubject(Subject subject) {
		return subjectRepository.save(subject);
	}
	@Override
	public void deleteSubject(Long subjectId) {
		subjectRepository.deleteById(subjectId);
	}

}
