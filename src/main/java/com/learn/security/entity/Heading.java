package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Heading")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Heading extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "heading_id")
    private Long headingId;

    // Many-to-one relationship with Topics
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    private Topic topic;

    @Lob
    private String headingText;
}
