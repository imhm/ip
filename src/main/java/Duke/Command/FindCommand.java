package Duke.Command;


import Duke.DukeException;
import Duke.Storage;
import Duke.Task.TaskList;
import Duke.Ui;

/**
 * Search the task list for tasks that contains the keyword specified by the user and prints them.
 */
public class FindCommand extends Command {
    private String keyword;


    public FindCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) throws DukeException {

        keyword = userInput.replace("find", "").trim();
        try {
            Ui.printFindTaskMessage(taskList, keyword);
        } catch (Exception e) {
            throw new DukeException("keyword not found");
        }
    }

}
