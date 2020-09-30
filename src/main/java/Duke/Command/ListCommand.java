package Duke.Command;

import Duke.Storage;
import Duke.Task.TaskList;
import Duke.Ui;

/**
 * Lists all tasks in the task list to the user.
 */
public class ListCommand extends Command{
    public ListCommand(String userInput) {
        super(userInput);
    }

    /**
     * Lists all tasks in the task list to the user.
     *
     * @param taskList the task list to list from.
     * @param storage not required.
     */
    @Override
    public void execute(TaskList taskList, Storage storage) {
        Ui.printTaskListView(taskList);
    }
}
