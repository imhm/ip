package Duke;

import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class FileAccess {

    public static final String dataFilePath = "./data/duke.txt";

    public static void saveData() {
        File output = new File(dataFilePath);
        createFile(output);
        try {
            FileWriter fw = new FileWriter(output);
            for (Task t : Task.taskList) {
                fw.write(t.toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void importData() {
        try {
            File input = new File(dataFilePath);
            Scanner s = new Scanner(input);
            while (s.hasNext()) {
                extractCommand(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing data imported.");
        }
    }

    private static void extractCommand(String command) {
        String task = command.substring(1, 2);
        String isDone = command.substring(3, 6);
        String taskDescription = command.substring(7);

        switch (task) {
        case "T":
            Task.setTaskList(new Todo(taskDescription));
            break;
        case "D":
            int indexEndOfDesc = taskDescription.indexOf(" (by: ");
            taskDescription= taskDescription.replace("(by: ", "");
            Task.setTaskList(new Deadline(taskDescription.substring(0, indexEndOfDesc),
                    taskDescription.substring(indexEndOfDesc, taskDescription.length() - 1)));
            break;
        case "E":
            indexEndOfDesc = taskDescription.indexOf(" (at: ");
            taskDescription=taskDescription.replace("(at: ", "");
            Task.setTaskList(new Event(taskDescription.substring(0, indexEndOfDesc),
                    taskDescription.substring(indexEndOfDesc, taskDescription.length() - 1)));
            break;
        default:
            System.out.println(task);
            break;
        }
        
        if (isDone.equals("[\u2713]")) {
            Task.taskList.get(Task.getTotalTask() - 1).markAsDone();
        }
    }

    private static void createFile(File output) {
        try {
            if (output.exists()) {
                System.out.println("File exists");
                return;
            }
            if (!output.getParentFile().exists()) {
                output.getParentFile().mkdirs();
            }
            output.createNewFile();
        } catch (IOException e) {
            System.out.println("Cannot create file; reason: " + e.getMessage());
        }
    }
}
