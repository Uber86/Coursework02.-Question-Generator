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
public class JavaQuestionRepository implements QuestionRepository {


    private final List<Question> questions;


    public JavaQuestionRepository (List<Question> questions) {
        this.questions = questions;
    }

    @PostConstruct
    public void init() {
        Random random = new Random();
        Question question = questions.get(random.nextInt(questions.size() - 1));
    }

    @Override
    public Question add(String question, String answer) {
        Question setOfQuestions = new Question(question, answer);
        if(questions.contains(setOfQuestions)){
            throw new QuestionAndAnswerAlreadyAdded();
        }
        questions.add(setOfQuestions);
        return setOfQuestions;
    }

    @Override
    public Question add(Question question) {
        if(questions.contains(question))
            throw new QuestionAlreadyAdded();
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question != null) {
            questions.remove(question);
        }
        throw new QuestionNotFound();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}

