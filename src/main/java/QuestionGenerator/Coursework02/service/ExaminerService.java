package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection <Question> getQuestions(int amount);
}
