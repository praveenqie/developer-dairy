package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Topic")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long topicId;


    @Column(nullable = false)
    private String topicName;

    @Lob
    private String description;

    // Getters and setters, constructors, and other methods

    // Many-to-one relationship with Subjects_Topics
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id",insertable = false,updatable = false)
    private SubjectTopic subjectTopic;

    // Many-to-one relationship with Flowcharts
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id",insertable = false,updatable = false)
    private Flowchart flowchart;

    // Many-to-one relationship with Headings
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id",insertable = false,updatable = false)
    private Heading heading;

    // Many-to-one relationship with ProgramExamples
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id",insertable = false,updatable = false)
    private ProgramExample programExample;

    // Many-to-one relationship with Diagrams
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id",insertable = false,updatable = false)
    private Diagram diagram;
}
