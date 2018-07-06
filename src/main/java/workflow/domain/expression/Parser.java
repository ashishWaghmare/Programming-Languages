package workflow.domain.expression;

import workflow.domain.Condition;

/**
 * Created by ashis on 7/4/2018.
 */
public class Parser {
    Tokenizer tokenizer;

    public Parser(Condition expression) {
        tokenizer = new Tokenizer(expression.getCondition());
    }

    public boolean eval(String context) {
        return new SimpleExpression(tokenizer,context).eval();
    }
}
