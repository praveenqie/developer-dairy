package com.learn.security.service;

import com.learn.security.entity.TutorialSubject;

import java.util.List;

public interface TutorialSubjectService {
    TutorialSubject getTutorialSubjectById(Long tutorialSubjectId);

    List<TutorialSubject> getAllTutorialSubjects();

    TutorialSubject saveTutorialSubject(TutorialSubject tutorialSubject);

    void deleteTutorialSubject(Long tutorialSubjectId);
}
