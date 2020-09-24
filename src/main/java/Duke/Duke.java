package Duke;

import Duke.Command.Command;
import Duke.Task.TaskList;

import java.io.FileNotFoundException;

public class Duke {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        taskList = new TaskList();

        try {
            storage.importData(taskList);
        } catch (FileNotFoundException e) {
            Ui.printNoImportDataMessage();
        }
    }

    public void run() {
        Ui.printWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                Ui.printDukeBorder(true);
                String fullCommand = ui.readCommand();
                Command c = Parser.handleUserInput(fullCommand);
                c.execute(taskList, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                Ui.printDukeExceptionMessage(e, taskList);
            } finally {
                Ui.printDukeBorder(false);
            }
        }
        Ui.printExitMessage();
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
