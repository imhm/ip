package Duke;

import Duke.Command.AddCommand;
import Duke.Command.Command;
import Duke.Command.DeleteCommand;
import Duke.Command.DoneCommand;
import Duke.Command.ExitCommand;
import Duke.Command.FindCommand;
import Duke.Command.ListCommand;

/**
 * Determines the type of command input by the user and calls for the respective command function.
 */
public class Parser {

    public static final String COMMAND_EXIT = "bye";
    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_DONE = "done";
    public static final String COMMAND_DELETE = "delete";
    public static final String COMMAND_FIND = "find";

    public static Command handleUserInput(String userInput) {

        if (userInput.equals(COMMAND_EXIT)) {
            return new ExitCommand(userInput);
        } else if (userInput.equals(COMMAND_LIST)) {
            return new ListCommand(userInput);
        } else if (userInput.startsWith(COMMAND_DONE)) {
            return new DoneCommand(userInput);
        } else if (userInput.startsWith(COMMAND_DELETE)) {
            return new DeleteCommand(userInput);
        } else if (userInput.startsWith(COMMAND_FIND)) {
            return new FindCommand(userInput);
        } else {
            /** An invalid command is catered for in AddCommand */
            return new AddCommand(userInput);
        }
    }
}
