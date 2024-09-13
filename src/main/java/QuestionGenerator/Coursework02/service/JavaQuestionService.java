package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.exception.QuestionAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionAndAnswerAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionNotFound;
import QuestionGenerator.Coursework02.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    
    private final List <Question> questions = new ArrayList<>();

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
        }else throw new QuestionNotFound();
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        return questions.get(random.nextInt(questions.size() - 1));

    }
}
