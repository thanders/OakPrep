package com.oakprep.backend.services;
import com.oakprep.backend.persistence.Exam;
import com.oakprep.backend.persistence.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TopicServiceImpl implements TopicService {

    private HashMap<String, Exam> examMap;
    private HashMap<String, Topic> examOneOrderMap;
    private HashMap<String, Topic> examTwoOrderMap;

    public TopicServiceImpl() {

        examMap = new HashMap<>();
        examOneOrderMap = new HashMap<>();
        examTwoOrderMap = new HashMap<>();

        examOneOrderMap.put("001A", new Topic("1Z0-815", "Understanding Java Technology  and environment"));
        examOneOrderMap.put("002A", new Topic("1Z0-815", "Working With Java Primitive Data Types and String APIs"));
        examOneOrderMap.put("003A", new Topic("1Z0-815","Working with Java Arrays"));

        examTwoOrderMap.put("001B", new Topic("1Z0-816", "Java Fundamentals"));
        examTwoOrderMap.put("002B", new Topic("1Z0-816", "Java Interfaces"));
        examTwoOrderMap.put("003B", new Topic("1Z0-816","Functional Interface and Lambda Expressions"));

        final Exam examOne = new Exam("1Z0-815", "Java SE 11 Programmer I", "multiple choice", "180", "80", "63", "java11", "https://education.oracle.com/java-se-11-programmer-i/pexam_1Z0-815");
        final Exam examTwo = new Exam("1Z0-816", "Java SE 11 Programmer I", "multiple choice", "180", "80", "63", "java11", "https://education.oracle.com/java-se-11-programmer-i/pexam_1Z0-816" );

        examOne.setTopics(examOneOrderMap);
        examTwo.setTopics(examTwoOrderMap);

        examMap.put("1Z0-815", examOne);
        examMap.put("1Z0-816", examTwo);

    }

    @Override
    public List<Topic> getAllTopicsForExam(final String examID) {
        System.out.println("getAllTopicsForExam - Exam ID: "+ examID);
        return new ArrayList<>(examMap.get(examID).getTopics().values());
    }

    @Override
    public Topic getTopicByIDForExam(final String examID, final String topicID) {
        final Map<String, Topic> topics = examMap.get(examID).getTopics();
        Topic selectedTopic = topics.get(topicID);
        return selectedTopic;
    }

}