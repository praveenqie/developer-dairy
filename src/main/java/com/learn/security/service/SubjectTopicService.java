package com.learn.security.service;

import com.learn.security.entity.SubjectTopic;

import java.util.List;

public interface SubjectTopicService {
    SubjectTopic getSubjectTopicById(Long subjectsTopicId);

    List<SubjectTopic> getAllSubjectTopics();

    SubjectTopic saveSubjectTopic(SubjectTopic subjectTopic);

    void deleteSubjectTopic(Long subjectsTopicId);
}
