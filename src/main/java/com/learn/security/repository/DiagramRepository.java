package com.learn.security.repository;

import com.learn.security.entity.Diagram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagramRepository extends JpaRepository<Diagram, Long> {
    // Custom query methods, if needed
}
