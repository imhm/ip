package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.task.TaskList;
import duke.Ui;

/**
 * Sets the task of task number specified by the user as done.
 */
public class DoneCommand extends Command {
    public DoneCommand(String command) {
        super(command);
    }

    /**
     * Sets the task of task number specified by the user as done.
     *
     * @param taskList the task list that contains the task.
     * @param storage  not required.
     * @throws DukeException if the done command is invalid.
     */
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
