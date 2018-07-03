package workflow.domain;

/**
 * Created by ashis on 7/2/2018.
 */
public class AnsweredStep extends Step {
    private String answered;

    public AnsweredStep(Step step){
        setName(step.getName());
        setQuestion(step.getQuestion());
        setAnswers(step.getAnswers());
    }

    public String getAnswered() {
        return answered;
    }

    public void setAnswered(String answered) {
        this.answered = answered;
    }
}
