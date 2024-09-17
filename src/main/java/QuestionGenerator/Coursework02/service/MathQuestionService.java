package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.exception.QuestionAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionAndAnswerAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionNotFound;
import QuestionGenerator.Coursework02.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {

    private final List<Question> questionsMath = new ArrayList<>();

    @Override
    public Question add(String question, String answer) {
        Question setOfQuestions = new Question(question, answer);
        if (questionsMath.contains(setOfQuestions)) {
            throw new QuestionAndAnswerAlreadyAdded();
        }
        questionsMath.add(setOfQuestions);
        return setOfQuestions;
    }

    @Override
    public Question add(Question question) {
        if (questionsMath.contains(question))
            throw new QuestionAlreadyAdded();
        questionsMath.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question != null) {
            questionsMath.remove(question);
        }
        throw new QuestionNotFound();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsMath);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return questionsMath.get(random.nextInt(questionsMath.size() - 1));

    }
}
