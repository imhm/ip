package Duke.Command;

import Duke.DukeException;
import Duke.Storage;
import Duke.Task.TaskList;

public abstract class Command {
    protected String userInput;

    public Command(String userInput) {
        this.userInput = userInput;
    }

    public abstract void execute(TaskList taskList, Storage storage) throws DukeException;

    public boolean isExit() {
        return false;
    }

}
