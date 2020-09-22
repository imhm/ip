package Duke;

import Duke.Task.TaskList;

import java.io.FileNotFoundException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
        parser = new Parser(tasks);

        try {
            storage.importData(parser);
        } catch (FileNotFoundException e) {
            Ui.printNoImportDataMessage();
        }
    }

    public void run() {
        //String fullCommand = ui.readCommand();
        parser.handleUserInput();
        Ui.printExitMessage();
        storage.saveData(tasks);
        /*
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
        try {
            String fullCommand = ui.readCommand();
            ui.showLine(); // show the divider line ("_______")
            Command c = Parser.parse(fullCommand);
            c.execute(tasks, ui, storage);
            isExit = c.isExit();
        } catch (DukeException e) {
            ui.showError(e.getMessage());
        } finally {
            ui.showLine();
        }
        */
    }

    public static void main(String[] args) {
        new Duke("data/tasks.txt").run();
    }
}
