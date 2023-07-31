package com.learn.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Description")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Description extends Timestamps{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long descriptionId;

    // Many-to-one relationship with Headings
    @ManyToOne
    @JoinColumn(name = "heading_id", referencedColumnName = "heading_id")
    private Heading heading;

    @Lob
    private String descriptionText;
}
