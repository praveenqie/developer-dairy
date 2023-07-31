package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "KeyPoint")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeyPoint extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;

    @ManyToOne
    @JoinColumn(name = "heading_id", referencedColumnName = "heading_id")
    private Heading heading;

    @Lob
    private String pointText;
}
