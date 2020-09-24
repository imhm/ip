package Duke.Command;

import Duke.DukeException;
import Duke.Storage;
import Duke.Task.TaskList;
import Duke.Ui;

/**
 * Deletes the task specified by the user.
 */
public class DeleteCommand extends Command {

    public DeleteCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws DukeException {
        int taskNumberDelete;

        try {
            taskNumberDelete = Integer.parseInt(userInput.replace("delete", "").trim());
        } catch (Exception e) {
            throw new DukeException("delete");
        }
        if (taskNumberDelete > taskList.getTotalTask()) {
            throw new DukeException("invalid task action");
        }

        Ui.printDeleteTaskMessage(taskNumberDelete, taskList);

        taskList.deleteTask(taskNumberDelete - 1); // - 1 to cater for index starting from 0

    }
}
