package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.exception.QuestionAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionAndAnswerAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionNotFound;
import QuestionGenerator.Coursework02.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    
    private final Set<Question> questions = new HashSet<>();

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
        questions.removeIf(e -> e.getQuestion().equals(question));
        throw new QuestionNotFound();

    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion(int number) {
        Random random = new Random();
        String result = String.valueOf(random.nextInt( number- 1));
        return null;

    }
}
