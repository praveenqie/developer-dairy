package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProgramExample")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramExample extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exampleId;

    // Many-to-one relationship with Topics
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    private Topic topic;

}
