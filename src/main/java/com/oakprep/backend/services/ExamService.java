package com.oakprep.backend.services;

import com.oakprep.backend.persistence.Exam;
import java.util.List;

public interface ExamService {

    List<Exam> allExams();

    Exam getExamDetail(final String examID);

}
