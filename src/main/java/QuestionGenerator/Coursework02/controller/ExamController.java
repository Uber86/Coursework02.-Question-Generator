package QuestionGenerator.Coursework02.controller;

import QuestionGenerator.Coursework02.model.Question;
import QuestionGenerator.Coursework02.service.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {

    public final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/random")
    public Collection<Question> random (@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }

}
