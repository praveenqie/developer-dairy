package com.learn.security.service;

import com.learn.security.entity.Tutorial;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TutorialsService {

    List<Tutorial> findAllTutorials();
    Tutorial getTutorialById(Integer tutorialId);

    Tutorial saveTutorial(Tutorial tutorial);

    void deleteTutorial(Integer tutorialId);


}
