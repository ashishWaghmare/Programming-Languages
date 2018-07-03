package workflow.domain;

/**
 * Created by ashis on 7/2/2018.
 */
public class Condition {
    private String from;
    private String to;
    private String condition;


    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
