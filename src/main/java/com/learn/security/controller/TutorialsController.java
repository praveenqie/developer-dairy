package com.learn.security.controller;

import com.learn.security.entity.Tutorial;
import com.learn.security.service.TutorialsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tutorial")
public class TutorialsController {
    private final TutorialsService tutorialService;

    @Autowired
    public TutorialsController(TutorialsService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorials(){
        List<Tutorial> tutorialList =tutorialService.findAllTutorials();
        return ResponseEntity.ok().body(tutorialList);
    }


    @GetMapping("/{tutorialId}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Integer tutorialId) {
        Tutorial tutorial = tutorialService.getTutorialById(tutorialId);
        if (tutorial != null) {
            return ResponseEntity.ok(tutorial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        Tutorial savedTutorial = tutorialService.saveTutorial(tutorial);
        return ResponseEntity.ok(savedTutorial);
    }

    @DeleteMapping("/{tutorialId}")
    public ResponseEntity<Void> deleteTutorial(@PathVariable Integer tutorialId) {
        tutorialService.deleteTutorial(tutorialId);
        return ResponseEntity.noContent().build();
    }
}
