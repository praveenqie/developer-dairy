package com.learn.security.service;

import com.learn.security.entity.Topic;

import java.util.List;

public interface TopicService {
    Topic getTopicById(Long topicId);

    List<Topic> getAllTopics();

    Topic saveTopic(Topic topic);

    void deleteTopic(Long topicId);
}
