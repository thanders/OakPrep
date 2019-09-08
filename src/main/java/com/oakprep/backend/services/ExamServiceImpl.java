package com.oakprep.backend.services;

import com.oakprep.backend.persistence.Exam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private HashMap<String, Exam> examMap;

    public ExamServiceImpl() {

        examMap = new HashMap<>();

        final Exam examOne = new Exam("1Z0-815", "Java SE 11 Programmer I", "multiple choice", "180", "80", "63", "java11", "https://education.oracle.com/java-se-11-programmer-i/pexam_1Z0-815" );
        final Exam examTwo = new Exam("1Z0-816", "Java SE 11 Programmer I", "multiple choice", "180", "80", "63", "java11", "https://education.oracle.com/java-se-11-programmer-i/pexam_1Z0-816" );

        examMap.put("1Z0-815", examOne);
        examMap.put("1Z0-816", examTwo);
    }

    @Override
    public List<Exam> allExams() {
        return new ArrayList<>(examMap.values());
    }

    @Override
    public Exam getExamDetail(final String examID) {
        return examMap.get(examID);
    }

}