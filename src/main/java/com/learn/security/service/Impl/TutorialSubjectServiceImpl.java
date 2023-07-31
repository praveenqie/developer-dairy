package com.learn.security.service.Impl;

import com.learn.security.entity.TutorialSubject;
import com.learn.security.repository.TutorialSubjectRepository;
import com.learn.security.service.TutorialSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TutorialSubjectServiceImpl implements TutorialSubjectService {
    private final TutorialSubjectRepository tutorialSubjectRepository;

    @Autowired
    public TutorialSubjectServiceImpl(TutorialSubjectRepository tutorialSubjectRepository) {
        this.tutorialSubjectRepository = tutorialSubjectRepository;
    }

    @Override
    public TutorialSubject getTutorialSubjectById(Long tutorialSubjectId) {
        return tutorialSubjectRepository.findById(tutorialSubjectId).orElse(null);
    }

    @Override
    public List<TutorialSubject> getAllTutorialSubjects() {
        return tutorialSubjectRepository.findAll();
    }

    @Override
    public TutorialSubject saveTutorialSubject(TutorialSubject tutorialSubject) {
        return tutorialSubjectRepository.save(tutorialSubject);
    }

    @Override
    public void deleteTutorialSubject(Long tutorialSubjectId) {
        tutorialSubjectRepository.deleteById(tutorialSubjectId);
    }
}
