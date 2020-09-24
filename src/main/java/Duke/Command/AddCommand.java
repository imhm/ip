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

    public AddCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws DukeException {
        String[] command;

        command = userInput.split(" ", 2);

        switch (command[0]) {
        case "todo":
            try {
                taskList.addTask(new Todo(command[1]));
            } catch (Exception e) {
                throw new DukeException("todo");
            }
            break;
        case "deadline":
            try {
                command = command[1].split("/by");
                taskList.addTask(new Deadline(command[0], command[1]));
            } catch (Exception e) {
                throw new DukeException("deadline");
            }
            break;
        case "event":
            try {
                command = command[1].split("/at");
                taskList.addTask(new Event(command[0], command[1]));
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
