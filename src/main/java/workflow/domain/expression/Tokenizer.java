package workflow.domain.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ashis on 7/4/2018.
 */
public class Tokenizer {

    private List<String> tokens=null;
    private  int pos;

    public Tokenizer(String expression) {
        String[] strings = expression.split(" ");
        tokens=Arrays.asList(strings);
        pos = 0;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public void setTokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public int size() {
        return tokens.size();
    }

    public String next() {
        return tokens.get(pos);
    }
}
