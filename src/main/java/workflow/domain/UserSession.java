package workflow.domain;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import workflow.Main;

import javax.security.auth.login.Configuration;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by ashis on 7/1/2018.
 */
public class UserSession {
    private Step current;
    private Steps workflow;
    private int index = 0;
    private Map<String, List<Condition>> fastCache = new HashMap<>();
    private Map<String, Integer> fastStepCache = new HashMap<>();

    private String defination = "/steps.yml";

    public Step getCurrent() {
        return current;
    }

    public void setCurrent(Step current) {
        this.current = current;
    }

    public void loadWorkflow(String fileName) throws IOException {
        try (InputStream in = Files.newInputStream(Paths.get(fileName))) {
            loadWorkflow(in);
        }
    }

    public void loadWorkflow() throws IOException {
        InputStream in = Main.class.getResourceAsStream(defination);
        loadWorkflow(in);
    }

    private void loadWorkflow(InputStream in) throws IOException {
        Constructor constructor = new Constructor(Steps.class);
        TypeDescription desc = new TypeDescription(Step.class);
        desc.putListPropertyType("answers", String.class);
        constructor.addTypeDescription(desc);
        Yaml yaml = new Yaml(constructor);
        workflow = yaml.loadAs(in, Steps.class);
        loadCaches();
        nextQuestion();
    }

    private void loadCaches() {
        workflow.getConditions().stream().forEach(it -> {
            List<Condition> lists = fastCache.get(it.getFrom());
            if (lists == null) {
                lists = new ArrayList<>();
                fastCache.put(it.getFrom(), lists);
            }
            lists.add(it);
        });
        for (int i = 0; i < workflow.getSteps().size(); i++) {
            fastStepCache.put(workflow.getSteps().get(i).getName(), i);
        }
    }

    public boolean submitAnswer(String respone) {
        List<String> possible = current.getAnswers();
        saveAnswer(respone);
        if (possible != null) {
            for (String p : possible) { // N2 very bad
                if (p.equalsIgnoreCase(respone)) {
                    nextQuestion();
                    return true;
                }
            }
            System.out.println("Invalid response:Possible " + Objects.toString(current.getAnswers()));
            return false;
        } else {
            nextQuestion();
        }
        return false;
    }

    private void saveAnswer(String response) {
        current = new AnsweredStep(current);
        ((AnsweredStep) current).setAnswered(response);
        workflow.getSteps().set(index - 1, current);
    }

    private void nextQuestion() {
        if (current != null) {
            List<Condition> conditions = fastCache.get(current.getName());
            if (conditions != null) {
                String nextStep = eval(current, conditions);
                gotoStep(nextStep);
                return;
            }
        }
        if (index < workflow.getSteps().size()) {
            current = workflow.getSteps().get(index++);
        } else {
            current = null;
        }
    }

    private void gotoStep(String step) {
        Integer index = fastStepCache.get(step);
        if (index != null) {
            current = workflow.getSteps().get(index);
            this.index = index;
        } else {
            System.out.println("Exit System");
            System.exit(0);
        }
    }

    private String eval(Step current, List<Condition> conditions) {
        if (current instanceof AnsweredStep) {
            String answer = ((AnsweredStep) current).getAnswered();
            for (Condition condition : conditions) {
                if (condition.getCondition().equalsIgnoreCase(answer)) {
                    return condition.getTo();
                }
            }
        }
        return null;
    }

    public boolean hasNextQuestion() {
        return current != null;
    }
}