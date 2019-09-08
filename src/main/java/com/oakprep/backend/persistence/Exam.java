package com.oakprep.backend.persistence;


import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Exam extends ResourceSupport {
    private String examID;
    private String name;
    private String examType;
    private String duration;
    private String questions;
    private String passMark;
    private String javaVersion;
    private String examURL;
    private Map<String, Topic> topics;

    // Constructor - empty
    public Exam() {
        super();
    }

    // Constructor - with arguments
    public Exam(final String examID, final String name, final String examType, final String duration, final String questions, final String passMark, final String javaVersion, final String examURL) {
        super();
        this.examID = examID;
        this.name = name;
        this.examType = examType;
        this.duration = duration;
        this.questions = questions;
        this.passMark = passMark;
        this.javaVersion = javaVersion;
        this.examURL = examURL;
    }

    // Getters and Setters

    public String getExamID() { return examID; }

    public void setExamID(final String examID) { this.examID = examID; }

    public String getName() { return name; }

    public void setName(final String name) { this.name = name; }

    public String getExamType() {
        return examType;
    }

    public void setExamType(final String examType) {
        this.examType = examType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(final String duration) {
        this.duration = duration;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(final String questions) {
        this.questions = questions;
    }

    public String getPassmark() {
        return passMark;
    }

    public void setPassMark(final Integer passmark) {
        this.passMark = passMark;
    }

    public String getJavaVersion() { return javaVersion; }

    public void setJavaVersion(final String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getExamURL() {
        return examURL;
    }

    public void setExamURL(final String examURL) {
        this.examURL = examURL;
    }

    public Map<String, Topic> getTopics() {
        return topics;
    }

    public void setTopics(final Map<String, Topic> topics) {
        this.topics = topics;
    }

}