package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.exception.BadRequest;
import QuestionGenerator.Coursework02.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> getQuestions(int amount) {
        Collection<Question> randomQuestion = new ArrayList<>();
        while (randomQuestion.size() < amount) {
            randomQuestion.add(questionService.getRandomQuestion());
        }
        if (questionService.getAll().size() < amount || amount<= 0) {
            throw new BadRequest();
        }
        return randomQuestion;





    }

}
