package Duke.Command;

import Duke.DukeException;
import Duke.Storage;
import Duke.Task.TaskList;
import Duke.Ui;

public class ListCommand extends Command{
    public ListCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws DukeException {
        Ui.printTaskListView(taskList);
    }
}
