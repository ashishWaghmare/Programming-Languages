package workflow.domain.expression;

/**
 * Created by ashis on 7/4/2018.
 */
public class Parser {
    Tokenizer tokenizer;

    public Parser(String expression){
        tokenizer=new Tokenizer(expression);
    }
}
