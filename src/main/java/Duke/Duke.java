package Duke;

import Duke.Command.Command;
import Duke.Task.TaskList;

import java.io.FileNotFoundException;

public class Duke {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        taskList = new TaskList();
        parser = new Parser(taskList);

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
                String fullCommand = ui.readCommand();
                Command c = parser.handleUserInput(fullCommand);
                c.execute(taskList, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                Ui.printDukeExceptionMessage(e, taskList);
            }
        }
        Ui.printExitMessage();
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
