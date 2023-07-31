package com.learn.security.repository;

import com.learn.security.entity.Flowchart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowchartRepository extends JpaRepository<Flowchart, Long> {
    // Custom query methods, if needed
}