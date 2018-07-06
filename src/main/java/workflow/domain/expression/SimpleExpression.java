package workflow.domain.expression;

/**
 * Created by ashis on 7/6/2018.
 */
public class SimpleExpression implements Expression {

    private Tokenizer tokenizer;
    private String context;

    public SimpleExpression(Tokenizer tokenizer, String context) {
        this.tokenizer = tokenizer;
        this.context = context;
    }

    @Override
    public boolean eval() {
        if (tokenizer.size() == 1) {
            String token = tokenizer.next();
            if (context.equalsIgnoreCase(token)) {
                return true;
            }
        }
        return false;
    }
}
