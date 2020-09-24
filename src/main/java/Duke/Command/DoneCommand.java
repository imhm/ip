package Duke.Command;

import Duke.DukeException;
import Duke.Storage;
import Duke.Task.TaskList;
import Duke.Ui;

/**
 * Set the task specified by the user as done.
 */
public class DoneCommand extends Command {
    public DoneCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws DukeException {
        int taskNumberCompleted;

        try {
            taskNumberCompleted = Integer.parseInt(userInput.replace("done", "").trim());
        } catch (Exception e) {
            throw new DukeException("done");
        }

        if (taskNumberCompleted > taskList.getTotalTask()) {
            throw new DukeException("invalid task action");
        }

        taskList.markTaskAsDone(taskNumberCompleted);

        Ui.printCompleteTaskMessage(taskNumberCompleted, taskList);
    }
}
