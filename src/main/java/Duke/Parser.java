package Duke;

import Duke.Command.*;

/**
 * Determine the type of command input by the user and calls for the respective command function.
 */
public class Parser {

    public static Command handleUserInput(String userInput) {

        if (userInput.equals("bye")) {
            return new ExitCommand(userInput);
        } else if (userInput.equals("list")) {
            return new ListCommand(userInput);
        } else if (userInput.startsWith("done")) {
            return new DoneCommand(userInput);
        } else if (userInput.startsWith("delete")) {
            return new DeleteCommand(userInput);
        } else if (userInput.startsWith("find")) {
            return new FindCommand(userInput);
        } else {
            return new AddCommand(userInput);
        }
    }
}
