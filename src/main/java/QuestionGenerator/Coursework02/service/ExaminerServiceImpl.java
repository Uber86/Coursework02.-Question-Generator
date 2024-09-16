package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.exception.BadRequest;
import QuestionGenerator.Coursework02.model.Question;
import QuestionGenerator.Coursework02.service.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    Random random;
    private final QuestionRepository questionRepository;

    public ExaminerServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Collection<Question> getQuestions(int amount) {
        Collection<Question> randomQuestion = new ArrayList<>();
        while (randomQuestion.size() < amount) {
            randomQuestion.add(questionRepository.getRandomQuestion());
        }
        if (questionRepository.getAll().size() < amount || amount<= 0) {
            throw new BadRequest();
        }
        return randomQuestion;





    }

}
