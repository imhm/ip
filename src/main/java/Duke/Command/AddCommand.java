package Duke.Command;

import Duke.DukeException;
import Duke.Storage;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.TaskList;
import Duke.Task.Todo;
import Duke.Ui;

/**
 * Adds a task to the task list, depending on what kind of task it is (event, deadline, todo)
 */
public class AddCommand extends Command {

    public static final String TODO = "todo";
    public static final String DEADLINE = "deadline";
    public static final String EVENT = "event";

    public AddCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws DukeException {
        String[] command;

        command = userInput.split(" ", 2);
        String commandType = command[0];
        String taskDescription;
        String taskDate;

        switch (commandType) {
        case TODO:
            try {
                taskDescription = command[1];
                taskList.addTask(new Todo(taskDescription));
            } catch (Exception e) {
                throw new DukeException("todo");
            }
            break;
        case DEADLINE:
            try {
                command = command[1].split("/by");
                taskDescription = command[0];
                taskDate = command[1];
                taskList.addTask(new Deadline(taskDescription, taskDate));
            } catch (Exception e) {
                throw new DukeException("deadline");
            }
            break;
        case EVENT:
            try {
                command = command[1].split("/at");
                taskDescription = command[0];
                taskDate = command[1];
                taskList.addTask(new Event(taskDescription, taskDate));
            } catch (Exception e) {
                throw new DukeException("event");
            }
            break;
        default:
            throw new DukeException("invalid command");
        }

        Ui.printAddTaskMessage(taskList);
    }
}
