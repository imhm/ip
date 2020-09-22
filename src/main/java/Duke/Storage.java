package Duke;

import Duke.Task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {

    private static String storageFilePath;
    public static final String TICK_SYMBOL = "[\u2713]";

    public Storage(String filePath) {
        storageFilePath = filePath;
    }

    public void saveData(TaskList taskList) {
        File output = new File(storageFilePath);
        createFile(output);
        try {
            FileWriter fw = new FileWriter(output);
            for (Task t : taskList.getTaskList()) {
                fw.write(t.toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            Ui.printSaveDataErrorMessage(e);
        }
    }

    public void importData(TaskList taskList) throws FileNotFoundException {
        try {
            File input = new File(storageFilePath);
            Scanner s = new Scanner(input);

            while (s.hasNext()) {
                extractCommandFromStorage(s.nextLine(), taskList);
            }
            Ui.printImportDataSuccessMessage();
        } catch (FileNotFoundException e) {
            Ui.printNoImportDataMessage();
        }
    }

    private static void createFile(File output) {
        try {
            if (output.exists()) {
                Ui.printFileOverwriteMessage();
                return;
            }
            if (!output.getParentFile().exists()) {
                output.getParentFile().mkdirs();
            }
            output.createNewFile();
            Ui.printFileCreatedMessage();
        } catch (IOException e) {
            Ui.printFileCreateErrorMessage(e);
        }
    }

    public void extractCommandFromStorage(String command, TaskList taskList) {
        String task = command.substring(1, 2);
        String isDone = command.substring(3, 6);
        String taskDescription = command.substring(7);

        switch (task) {
        case "T":
            taskList.addTask(new Todo(taskDescription));
            break;
        case "D":
            int indexEndOfDesc = taskDescription.indexOf(" (by: ");
            taskDescription = taskDescription.replace("(by: ", "");
            taskList.addTask(new Deadline(taskDescription.substring(0, indexEndOfDesc),
                    taskDescription.substring(indexEndOfDesc, taskDescription.length() - 1)));
            break;
        case "E":
            indexEndOfDesc = taskDescription.indexOf(" (at: ");
            taskDescription = taskDescription.replace("(at: ", "");
            taskList.addTask(new Event(taskDescription.substring(0, indexEndOfDesc),
                    taskDescription.substring(indexEndOfDesc, taskDescription.length() - 1)));
            break;
        default:
            System.out.println(task);
            break;
        }

        if (isDone.equals(TICK_SYMBOL)) {
            taskList.markTaskAsDone(taskList.getTotalTask());
        }
    }
}
