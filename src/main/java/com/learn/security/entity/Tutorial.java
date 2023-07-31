package com.learn.security.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tutorial")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tutorial_id")
    private Long tutorialId;

    private String title;

    private String description;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name = "tutorial_id", referencedColumnName = "tutorial_id",insertable = false,updatable = false)
//    private TutorialSubject tutorialSubject;
}
