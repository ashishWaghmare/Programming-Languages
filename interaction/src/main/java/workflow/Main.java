package workflow;

import org.apache.commons.cli.*;
import workflow.domain.UserSession;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ashis on 7/1/2018.
 */
public class Main {

    public static String FILE_OPTION = "f";

    public static void main(String[] args) throws IOException, ParseException {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(commandLine(), args);
        Scanner userInput = new Scanner(System.in);
        UserSession user = new UserSession();
        if (cmd.hasOption(FILE_OPTION)) {
            user.loadWorkflow(cmd.getOptionValue(FILE_OPTION));
        } else {
            user.loadWorkflow();
        }
        while (user.hasNextQuestion()) { // TODO identify end step
            String questionToAsk = user.getCurrent().getQuestion();
            System.out.println(questionToAsk);
            String response = userInput.next();
            user.submitAnswer(response);
        }
    }

    public static Options commandLine() {
        final Option fileOption = Option.builder("f")
                .required()
                .longOpt(FILE_OPTION)
                .hasArg()
                .desc("Supply your YAML file")
                .build();
        final Options options = new Options();
        options.addOption(fileOption);
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar sms-magic.jar", options);
        return options;
    }
}
