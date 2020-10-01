package duke.command;

import duke.Storage;
import duke.task.TaskList;
import duke.Ui;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command {
    public ListCommand(String userInput) {
        super(userInput);
    }

    /**
     * Lists all tasks in the task list to the user.
     *
     * @param taskList the task list to list from.
     * @param storage  not required.
     */
    @Override
    public void execute(TaskList taskList, Storage storage) {
        Ui.printTaskListView(taskList);
    }
}
