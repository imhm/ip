package Duke;

import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

import java.util.Scanner;

public abstract class CommandHandler {

    public static void handleUserInput() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().trim();

        while (!userInput.equals("bye")) {
            try {
                if (userInput.equals("list")) {
                    userViewTaskList();
                } else {
                    if (userInput.contains("done")) {
                        userCompleteTask(userInput);
                    } else {
                        userAddTask(userInput);
                    }
                }
            } catch (DukeException e) {
                DukeExceptionHandler(e);
            }

            userInput = in.nextLine().trim();
        }
    }

    private static void DukeExceptionHandler(DukeException e) {
        switch (e.getException()) {
        case "todo":
            System.out.println("Error: The description of todo cannot be empty.");
            break;
        case "deadline":
            System.out.println("Error: Please key in the deadline in this format: deadline ... /by ...");
            break;
        case "event":
            System.out.println("Error: Please key in the event in this format: deadline ... /at ...");
            break;
        case "invalid command":
            System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                    "Available commands: list, done, todo, deadline, event");
            break;
        case "invalid task complete":
            System.out.println("Error: Total task(s): " + Task.getTotalTask());
            break;
        default:
            break;
        }
    }

    public static void userAddTask(String userInput) throws DukeException {
        String[] command;

        command = userInput.split(" ", 2);

        switch (command[0]) {
        case "todo":
            try {
                Task.setTaskList(new Todo(command[1]));
            } catch (Exception e) {
                throw new DukeException("todo");
            }
            break;
        case "deadline":
            try {
                command = command[1].split("/by");
                Task.setTaskList(new Deadline(command[0], command[1]));
            } catch (Exception e) {
                throw new DukeException("deadline");
            }
            break;
        case "event":
            try {
                command = command[1].split("/at");
                Task.setTaskList(new Event(command[0], command[1]));
            } catch (Exception e) {
                throw new DukeException("event");
            }
            break;
        default:
            throw new DukeException("invalid command");
        }

        Duke.printDukeBorder(true);
        System.out.println("Got it. I've added this task:");
        System.out.println(Task.taskList.get(Task.taskList.size() - 1));
        System.out.println("Your total tasks: " + Task.getTotalTask());
        Duke.printDukeBorder(false);
    }

    public static void userCompleteTask(String userInput) throws DukeException {
        int taskNumberCompleted = Integer.parseInt(userInput.replace("done", "").trim());

        if (taskNumberCompleted > Task.getTotalTask()) {
            throw new DukeException("invalid task complete");
        }

        Task.taskList.get(taskNumberCompleted - 1).markAsDone(); // - 1 to cater for index starting from 0

        Duke.printDukeBorder(true);
        System.out.println("Good work! I've marked this task as done:\n" + Task.taskList.get(taskNumberCompleted - 1));
        Duke.printDukeBorder(false);
    }

    public static void userViewTaskList() {
        Duke.printDukeBorder(true);
        System.out.println("This is your list of task(s):");
        for (int i = 0; i < Task.getTotalTask(); i++) {
            System.out.printf("%d." + Task.taskList.get(i) + "\n", i + 1);
        }
        Duke.printDukeBorder(false);
    }
}