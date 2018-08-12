package workflow.domain;

import java.util.List;

/**
 * Created by ashis on 7/1/2018.
 */
public class Step {

    private String name;
    private String question;

    private List<String> answers;

    public Step() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
