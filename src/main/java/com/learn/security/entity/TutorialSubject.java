package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TutorialSubject")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorialSubject extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tutorialSubjectId;

    // Many-to-one relationship with Tutorials
    @ManyToOne
    @JoinColumn(name = "tutorial_id", referencedColumnName = "tutorial_id")
    private Tutorial tutorial;

    // Many-to-one relationship with Subjects
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;

}
