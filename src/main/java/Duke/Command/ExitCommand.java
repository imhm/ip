package Duke.Command;

import Duke.Storage;
import Duke.Task.TaskList;

public class ExitCommand extends Command{

    public ExitCommand(String userInput) {
        super(userInput);
    }

    @Override
    public void execute(TaskList taskList, Storage storage) {
        storage.saveData(taskList);
    }

    @Override
    public boolean isExit(){
        return true;
    }
}
