package com.learn.security.controller;

import com.learn.security.entity.TutorialSubject;
import com.learn.security.service.TutorialSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tutorial_subjects")
public class TutorialSubjectController {
    private final TutorialSubjectService tutorialSubjectService;

    @Autowired
    public TutorialSubjectController(TutorialSubjectService tutorialSubjectService) {
        this.tutorialSubjectService = tutorialSubjectService;
    }

    @GetMapping("/{tutorialSubjectId}")
    public ResponseEntity<TutorialSubject> getTutorialSubjectById(@PathVariable Long tutorialSubjectId) {
        TutorialSubject tutorialSubject = tutorialSubjectService.getTutorialSubjectById(tutorialSubjectId);
        if (tutorialSubject != null) {
            return ResponseEntity.ok(tutorialSubject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TutorialSubject>> getAllTutorialSubjects() {
        List<TutorialSubject> tutorialSubjects = tutorialSubjectService.getAllTutorialSubjects();
        return ResponseEntity.ok(tutorialSubjects);
    }

    @PostMapping
    public ResponseEntity<TutorialSubject> createTutorialSubject(@RequestBody TutorialSubject tutorialSubject) {
        TutorialSubject savedTutorialSubject = tutorialSubjectService.saveTutorialSubject(tutorialSubject);
        return ResponseEntity.ok(savedTutorialSubject);
    }

    @DeleteMapping("/{tutorialSubjectId}")
    public ResponseEntity<Void> deleteTutorialSubject(@PathVariable Long tutorialSubjectId) {
        tutorialSubjectService.deleteTutorialSubject(tutorialSubjectId);
        return ResponseEntity.noContent().build();
    }
}
