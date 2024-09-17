package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.exception.BadRequest;
import QuestionGenerator.Coursework02.exception.QuestionAlreadyAdded;
import QuestionGenerator.Coursework02.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService qService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        List<Question> questions = new ArrayList<>(List.of(
                new Question("Test", "Testtest"),
                new Question("Test", "Testtest1"),
                new Question("Test1", "Testtest1")

        ));
        when(qService.getAll()).thenReturn(questions);
    }
    @Test
    void randomTestThrow() {
        assertThrows(BadRequest.class, () -> examinerService.getQuestions(5));
        assertThrows(BadRequest.class, () -> examinerService.getQuestions(-4));

    }

    /*
    @Test
    void generatorTest() {
        when(qService.getRandomQuestion()).thenReturn(new Question("Test1", "Testtest1"));
        Collection<Question> q1 = qService.getAll();
        assertThrows(q1.)
    }

     */









}