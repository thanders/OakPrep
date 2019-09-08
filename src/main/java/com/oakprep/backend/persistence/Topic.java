package com.oakprep.backend.persistence;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.bson.types.ObjectId;
import org.springframework.hateoas.ResourceSupport;

import java.util.Map;

@JsonInclude(Include.NON_NULL)
public class Topic extends ResourceSupport {
    // public ObjectId _id;
    private String topicID;
    private String topic;
    //private Map<String, SubTopic> subtopics;

    // Constructor - empty
    public Topic() {
        super();
    }

    // Constructor - with arguments
    public Topic(final String topicID, final String topic/*, final  Map<String, SubTopic> subtopics*/) {
        super();
        this.topicID = topicID;
        this.topic = topic;
        //this.subtopics = subtopics;
    }

    // Getters and Setters

    public String getTopicID() {
        return topicID;
    }

    public void setTopicID(final String topicID) { this.topicID = topicID; }

    public String getTopic() { return topic; }

    public void setTopic(final String topic) { this.topic = topic; }
    /*
    public Map<String, SubTopic> getSubTopics() {
        return subtopics;
    }

    public void setTopic(final Map<String, Topic> topics) {
        this.topics = topics;
    }
    */
}