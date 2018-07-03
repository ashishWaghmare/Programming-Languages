package workflow.domain;

import java.util.List;

/**
 * Created by ashis on 7/1/2018.
 */
public class Steps {
    private List<Step> steps;
    private List<Condition> conditions;

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
