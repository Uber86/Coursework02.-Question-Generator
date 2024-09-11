package QuestionGenerator.Coursework02.exception;

public class QuestionAndAnswerAlreadyAdded extends RuntimeException {

    public QuestionAndAnswerAlreadyAdded() {
    }

    public QuestionAndAnswerAlreadyAdded(String message) {
        super(message);
    }

    public QuestionAndAnswerAlreadyAdded(String message, Throwable cause) {
        super(message, cause);
    }
}
