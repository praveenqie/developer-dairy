package com.learn.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.learn.security.entity.Subject;
import com.learn.security.service.SubjectService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/subject")
@Tag(name = "subject")
public class SubjectController {
	private final SubjectService subjectService;

	@Autowired
	public SubjectController(SubjectService subjectService) {
		this.subjectService = subjectService;
	}


	@GetMapping("/{subjectId}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Long subjectId) {
		Subject subject = subjectService.getSubjectById(subjectId);
		if (subject != null) {
			return ResponseEntity.ok(subject);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Subject>> getAllSubjects() {
		List<Subject> subjects = subjectService.getAllSubjects();
		return ResponseEntity.ok(subjects);
	}

	@PostMapping
	public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
		Subject savedSubject = subjectService.saveSubject(subject);
		return ResponseEntity.ok(savedSubject);
	}

	@DeleteMapping("/{subjectId}")
	public ResponseEntity<Void> deleteSubject(@PathVariable Long subjectId) {
		subjectService.deleteSubject(subjectId);
		return ResponseEntity.noContent().build();
	}
}
