package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject")
public class Subject extends Timestamps {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subject_id")
	private Long subjectId;

	@Column(nullable = false)
	private String subjectName;

	@Lob
	private String description;

	// Many-to-one relationship with TutorialSubject
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id",insertable = false,updatable = false)
	private TutorialSubject tutorialSubject;

	// Many-to-one relationship with SubjectTopic
	@ManyToOne
	@JoinColumn(name = "subject_id", referencedColumnName = "subject_id",insertable = false,updatable = false)
	private SubjectTopic subjectTopic;

}
