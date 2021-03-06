package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.Ui;
import duke.task.TaskList;

/**
 * Deletes the task of task number specified by the user.
 */
public class DeleteCommand extends Command {

    public DeleteCommand(String command) {
        super(command);
    }

    /**
     * Deletes the task of task number specified by the user.
     * Saves the updated task list in the storage after the task is deleted.
     *
     * @param taskList the task list to delete the task from.
     * @param storage  the storage to be saved to.
     * @throws DukeException if the delete command input is invalid.
     */
    @Override
    public void execute(TaskList taskList, Storage storage) throws DukeException {
        int taskNumberDelete;

        try {
            taskNumberDelete = Integer.parseInt(userInput.replace("delete", "").trim());
        } catch (Exception e) {
            throw new DukeException("delete");
        }
        if (taskNumberDelete > taskList.getTotalTask() || taskNumberDelete <= 0) {
            throw new DukeException("invalid task action");
        }

        Ui.printDeleteTaskMessage(taskNumberDelete, taskList);

        taskList.deleteTask(taskNumberDelete - 1); // - 1 to cater for index starting from 0
        storage.saveData(taskList);

    }
}
