package com.learn.security.service.Impl;

import com.learn.security.entity.Topic;
import com.learn.security.repository.TopicRepository;
import com.learn.security.service.TopicService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    private final TopicRepository topicRepository;

    @Autowired
    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public Topic getTopicById(Long topicId) {
        return topicRepository.findById(topicId).orElse(null);
    }


    @Override
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }


    @Override
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }


    @Override
    public void deleteTopic(Long topicId) {
        topicRepository.deleteById(topicId);
    }
}
