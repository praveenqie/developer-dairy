package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Diagram")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Diagram extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diagramId;

    // Many-to-one relationship with Topics
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    private Topic topic;

    @Column(nullable = false)
    private String diagramName;

    private String diagramImageUrl;

}
