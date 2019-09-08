package com.oakprep.backend.controller;

import com.oakprep.backend.persistence.Exam;
import com.oakprep.backend.persistence.Topic;
import com.oakprep.backend.services.ExamService;
import com.oakprep.backend.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/exams")
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class ExamController {
    @Autowired
    private ExamService examService;

    @Autowired
    private TopicService topicService;

    @GetMapping("/{examID}")
    public Exam getCustomerById(@PathVariable final String examID) {
        return examService.getExamDetail(examID);
    }

    @GetMapping("/{examID}/{topicID}")
    public Topic getTopicByID(@PathVariable final String examID, @PathVariable final String topicID) {
        return topicService.getTopicByIDForExam(examID, topicID);
    }

    @GetMapping(value = "/{examID}/topics", produces = { "application/hal+json" })
    public Resources<Topic> getTopicsForExam(@PathVariable final String examID) {
        final List<Topic> topics = topicService.getAllTopicsForExam(examID);
        for (final Topic topic : topics) {
            final Link selfLink = linkTo(
                    methodOn(ExamController.class).getTopicByID(examID, topic.getTopicID())).withSelfRel();
            topic.add(selfLink);
        }

        Link link = linkTo(methodOn(ExamController.class).getTopicsForExam(examID)).withSelfRel();
        Resources<Topic> result = new Resources<>(topics, link);
        return result;
    }

    // getAllExams()
    @GetMapping(produces = { "application/hal+json" })
    public Resources<Exam> getAllExams() {
        final List<Exam> allExams = examService.allExams();

        for (final Exam exam : allExams) {
            System.out.println("Exam ID: "+ exam);
            String examID = exam.getExamID();
            Link selfLink = linkTo(ExamController.class).slash(examID)
                    .withSelfRel();
            exam.add(selfLink);

            if (topicService.getAllTopicsForExam(examID)
                    .size() > 0) {
                final Link topicsLink = linkTo(methodOn(ExamController.class).getTopicsForExam(examID))
                        .withRel("allTopics");
                exam.add(topicsLink);
            }
        }

        Link link = linkTo(ExamController.class).withSelfRel();
        Resources<Exam> result = new Resources<>(allExams, link);
        return result;
    }

}