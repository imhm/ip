package Duke;

import Duke.Command.*;
import Duke.Task.*;

import java.util.Scanner;

public class Parser {

    private TaskList taskList;

    public Parser(TaskList taskList) {
        this.taskList = taskList;
    }


    public Command handleUserInput(String userInput) {

        if (userInput.equals("bye")) {
            return new ExitCommand(userInput);
        } else if (userInput.equals("list")) {
            return new ListCommand(userInput);
        } else if (userInput.contains("done")) {
            return new DoneCommand(userInput);
        } else if (userInput.contains("delete")) {
            return new DeleteCommand(userInput);
        } else {
            return new AddCommand(userInput);
        }


    }


}
