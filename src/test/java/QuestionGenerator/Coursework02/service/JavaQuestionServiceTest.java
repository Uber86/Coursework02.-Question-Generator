package QuestionGenerator.Coursework02.service;

import QuestionGenerator.Coursework02.exception.QuestionAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionAndAnswerAlreadyAdded;
import QuestionGenerator.Coursework02.exception.QuestionNotFound;
import QuestionGenerator.Coursework02.model.Question;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JavaQuestionServiceTest {

    JavaQuestionService qService = new JavaQuestionService();

    @Test
    void addTest() {
        qService.add("Test", "Testtest");
        qService.add("Test", "Testtest1");
        qService.add("Test1", "Testtest1");

        assertThat(qService.getAll()).size().isEqualTo(3);

        var addQ = qService.add("Test2", "Testtest2");
        assertThat(addQ.getQuestion()).isEqualTo("Test2");
        assertThat(addQ.getAnswer()).isEqualTo("Testtest2");

        assertThat(qService.getAll()).size().isEqualTo(4);
        assertThat(qService.getAll()).contains(addQ);
    }

    @Test
    void addThrowTest() {
        qService.add("Test1", "Testtest");
        qService.add("Test", "Testtest1");
        var que = qService.add("Test", "Testtest");
        assertThat(que).isNotNull();

        assertThrows(QuestionAndAnswerAlreadyAdded.class, () -> qService.add("Test", "Testtest1"));
        assertThrows(QuestionAndAnswerAlreadyAdded.class, () -> qService.add("Test1", "Testtest"));

    }

    @Test
    void removeTest() {
        qService.add("Test", "Testtest");
        qService.add("Test", "Testtest1");
        qService.add("Test1", "Testtest1");
        Question question1 = new Question("Test2", "Testtest1");
        assertThat(question1).isNotNull();
        assertThrows(QuestionNotFound.class, () -> qService.remove(question1));

    }

    /*
    @Test
    void removeTestNull() {
        qService.add("Test", "Testtest");
        qService.add("Test", "Testtest1");
        service.remove("Lemon3", "Lemonad3", 4600,2);

    }

     */

    @Test
    void addQuesTestThrow() {
        qService.add("Test", "Testtest");
        qService.add("Test", "Testtest1");
        qService.add("Test1", "Testtest1");
        Question question1 = new Question("Test1", "Testtest1");
        assertThrows(QuestionAlreadyAdded.class, () -> qService.add(question1));

    }

    @Test
    void addQuesTest() {
        qService.add("Test", "Testtest");
        qService.add("Test", "Testtest1");
        qService.add("Test1", "Testtest1");
        assertThat(qService.getAll()).size().isEqualTo(3);
        Question question1 = new Question("Test2", "Testtest2");
        var addQ = qService.add(question1);
        assertThat(addQ.getQuestion()).isEqualTo("Test2");
        assertThat(addQ.getAnswer()).isEqualTo("Testtest2");

        assertThat(qService.getAll()).size().isEqualTo(4);
        assertThat(qService.getAll()).contains(addQ);
    }




}