package QuestionGenerator.Coursework02.exception;

public class QuestionNotFound extends RuntimeException {

    public QuestionNotFound() {
    }

    public QuestionNotFound(String message) {
        super(message);
    }

    public QuestionNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
