package com.learn.security.service.Impl;

import com.learn.security.entity.SubjectTopic;
import com.learn.security.repository.SubjectTopicRepository;
import com.learn.security.service.SubjectTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectTopicServiceImpl implements SubjectTopicService {
    private final SubjectTopicRepository subjectTopicRepository;

    @Autowired
    public SubjectTopicServiceImpl(SubjectTopicRepository subjectTopicRepository) {
        this.subjectTopicRepository = subjectTopicRepository;
    }

    @Override
    public SubjectTopic getSubjectTopicById(Long subjectsTopicId) {
        return subjectTopicRepository.findById(subjectsTopicId).orElse(null);
    }

    @Override
    public List<SubjectTopic> getAllSubjectTopics() {
        return subjectTopicRepository.findAll();
    }

    @Override
    public SubjectTopic saveSubjectTopic(SubjectTopic subjectTopic) {
        return subjectTopicRepository.save(subjectTopic);
    }

    @Override
    public void deleteSubjectTopic(Long subjectsTopicId) {
        subjectTopicRepository.deleteById(subjectsTopicId);
    }
}
