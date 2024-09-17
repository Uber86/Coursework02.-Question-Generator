package QuestionGenerator.Coursework02.service.repository;

import QuestionGenerator.Coursework02.model.Question;

import java.util.Collection;

public interface QuestionRepository {



    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

}
