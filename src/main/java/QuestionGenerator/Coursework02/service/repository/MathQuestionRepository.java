package QuestionGenerator.Coursework02.service.repository;

import QuestionGenerator.Coursework02.exception.QuestionAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionAndAnswerAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionNotFound;
import QuestionGenerator.Coursework02.model.Question;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Repository
@SessionScope
public class MathQuestionRepository implements QuestionRepository {

    private final List<Question> questionsMath;

    public MathQuestionRepository(List<Question> questionsMath) {
        this.questionsMath = questionsMath;
    }

    @PostConstruct
    public void init() {
        Random random = new Random();
        Question question = questionsMath.get(random.nextInt(questionsMath.size() - 1));
    }


    @Override
    public Question add(String question, String answer) {
        Question setOfQuestions = new Question(question, answer);
        if(questionsMath.contains(setOfQuestions)){
            throw new QuestionAndAnswerAlreadyAdded();
        }
        questionsMath.add(setOfQuestions);
        return setOfQuestions;
    }

    @Override
    public Question add(Question question) {
        if(questionsMath.contains(question))
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

}
