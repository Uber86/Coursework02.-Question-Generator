package QuestionGenerator.Coursework02.controller;

import QuestionGenerator.Coursework02.model.Question;
import QuestionGenerator.Coursework02.service.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final JavaQuestionService service;

    public JavaQuestionController( JavaQuestionService service) {
        this.service = service;
    }

    @GetMapping (path = "/add")
    public void addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        service.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public void removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question question1 = new Question(question, answer);
        service.remove(question1);
    }

    @GetMapping
    public Collection<Question> getQuestion() {
        return service.getAll();
    }
}
