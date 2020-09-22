package Duke;

import Duke.Task.TaskList;

import java.io.IOException;
import java.util.Scanner;

public class Ui {
    private Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public String readCommand() {
        String userInput = in.nextLine().trim();
        return userInput;
    }

    public static void printWelcomeMessage() {
        printDukeBorder(true);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?");
        printDukeBorder(false);
    }

    public static void printExitMessage() {
        printDukeBorder(true);
        System.out.println("Bye. Hope to see you again soon!\n");
        printDukeBorder(false);
    }

    public static void printDukeBorder(boolean top) {
        if (top) {
            System.out.println("............. DUKE CHATBOX ^^ ............");
        } else {
            System.out.println("..........................................");
        }
    }

    public static void printDeleteTaskMessage(int taskNumberDelete, TaskList taskList) {
        printDukeBorder(true);
        System.out.println("Task deleted:\n" + taskList.getTaskList().get(taskNumberDelete - 1));
        System.out.println("Your total tasks: " + (taskList.getTotalTask() - 1));
        printDukeBorder(false);
    }

    public static void printTaskListView(TaskList taskList) {
        printDukeBorder(true);
        System.out.println("This is your list of task(s):");
        for (int i = 0; i < taskList.getTotalTask(); i++) {
            System.out.printf("%d." + taskList.getTaskList().get(i) + "\n", i + 1);
        }
        printDukeBorder(false);
    }

    public static void printCompleteTaskMessage(int taskNumberCompleted, TaskList taskList) {
        printDukeBorder(true);
        System.out.println("Good work! I've marked this task as done:\n" + taskList.getTaskList().get(taskNumberCompleted - 1));
        printDukeBorder(false);
    }

    public static void printAddTaskMessage(TaskList taskList) {
        printDukeBorder(true);
        System.out.println("Got it. I've added this task:");
        System.out.println(taskList.getTaskList().get(taskList.getTaskList().size() - 1));
        System.out.println("Your total tasks: " + taskList.getTotalTask());
        printDukeBorder(false);
    }

    public static void printDukeExceptionMessage(DukeException e, TaskList taskList) {
        switch (e.getException()) {
        case "todo":
            System.out.println("Error: The description of todo cannot be empty.");
            break;
        case "deadline":
            System.out.println("Error: Please key in the deadline in this format: deadline ... /by ...");
            break;
        case "event":
            System.out.println("Error: Please key in the event in this format: event ... /at ...");
            break;
        case "invalid command":
            System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                    "Available commands: list, done, todo, deadline, event");
            break;
        case "invalid task action":
            System.out.println("Error: Total task(s): " + taskList.getTotalTask());
            break;
        case "done":
            System.out.println("Error: Please key in the command in this format: done <task number>");
            break;
        case "delete":
            System.out.println("Error: Please key in the command in this format: delete <task number>");
            break;
        default:
            System.out.println("Unknown Error.");
            break;
        }
    }

    public static void printSaveDataErrorMessage(IOException e) {
        System.out.println("Unable to save data. Error: " + e.getMessage());
    }

    public static void printNoImportDataMessage() {
        System.out.println("No existing data imported.");
    }

    public static void printImportDataSuccessMessage() {
        System.out.println("Existing data imported.");
    }

    public static void printFileCreateErrorMessage(IOException e) {
        System.out.println("Cannot create file; reason: " + e.getMessage());
    }

    public static void printFileCreatedMessage() {
        System.out.println("New output file created.");
    }

    public static void printFileOverwriteMessage() {
        System.out.println("File exists. Data overwrite.");
    }
}
