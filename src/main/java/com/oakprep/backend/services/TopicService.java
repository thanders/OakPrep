package com.oakprep.backend.services;

import com.oakprep.backend.persistence.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopicsForExam(String examID);

    Topic getTopicByIDForExam(String examID, String topicID);

}