package com.learn.security.service.Impl;

import com.learn.security.entity.Subject;
import com.learn.security.entity.Tutorial;
import com.learn.security.repository.SubjectRepository;
import com.learn.security.repository.TutorialsRepository;
import com.learn.security.service.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TutorialsServiceImpl implements TutorialsService {
        private final TutorialsRepository tutorialRepository;

        @Autowired
        public TutorialsServiceImpl(TutorialsRepository tutorialRepository) {
            this.tutorialRepository = tutorialRepository;
        }

    @Override
    public List<Tutorial> findAllTutorials() {
       return tutorialRepository.findAll();
    }

    @Override
        public Tutorial getTutorialById(Integer tutorialId) {
            return tutorialRepository.findById(Long.valueOf(tutorialId)).orElse(null);
        }

    @Override
        public Tutorial saveTutorial(Tutorial tutorial) {
            return tutorialRepository.save(tutorial);
        }

    @Override
        public void deleteTutorial(Integer tutorialId) {
            tutorialRepository.deleteById(Long.valueOf(tutorialId));
        }

}
