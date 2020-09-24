package Duke;

import Duke.Command.Command;
import Duke.Task.TaskList;

import java.io.FileNotFoundException;

/**
 *Entry point of the Duke application.
 *Initializes the application and starts the interaction with the user.
 */
public class Duke {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private Parser parser;

    /**
     * Initializes the application and imports the data stored locally to the application.
     * @param filePath Filepath of the storage data.
     */
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

    /**
     * Reads the user command and executes it, until the user issues the exit command.
     * Greets the user upon start up and exit.
     */
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
