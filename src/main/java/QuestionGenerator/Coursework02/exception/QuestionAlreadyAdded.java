package QuestionGenerator.Coursework02.exception;

public class QuestionAlreadyAdded extends RuntimeException{

    public QuestionAlreadyAdded() {
    }

    public QuestionAlreadyAdded(String message) {
        super(message);
    }

    public QuestionAlreadyAdded(String message, Throwable cause) {
        super(message, cause);
    }
}
