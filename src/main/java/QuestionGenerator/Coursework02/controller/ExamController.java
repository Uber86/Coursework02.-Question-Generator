package QuestionGenerator.Coursework02.controller;

import QuestionGenerator.Coursework02.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam/java")
public class ExamController {

    public final ExamController examController;

    public ExamController(ExamController examController) {
        this.examController = examController;
    }

    @GetMapping(path = "/random")
    public void getQuestions(@RequestParam int amount) {
        examController.getQuestions(amount);
    }

}
