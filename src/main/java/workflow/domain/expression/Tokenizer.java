package workflow.domain.expression;

import java.util.List;

/**
 * Created by ashis on 7/4/2018.
 */
public class Tokenizer {

    List<String> tokens;
    int pos;

    public Tokenizer(String expression) {
        tokens = expression.split(" ");
        pos = 0;
    }
}
