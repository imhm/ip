package Duke;

import Duke.Task.*;

import java.util.Scanner;

public class Parser {
    public static final String TICK_SYMBOL = "[\u2713]";
    private TaskList taskList;

    public Parser(TaskList taskList){
        this.taskList = taskList;
    }

    public void handleUserInput() {

        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().trim();


        while (!userInput.equals("bye")) {
            try {
                if (userInput.equals("list")) {
                    userViewTaskList();
                } else if (userInput.contains("done")) {
                    userCompleteTask(userInput);
                } else if (userInput.contains("delete")) {
                    userDeleteTask(userInput);
                } else {
                    userAddTask(userInput);
                }

            } catch (DukeException e) {
                Ui.printDukeExceptionMessage(e,taskList);
            }

            userInput = in.nextLine().trim();
        }
    }

    private void userAddTask(String userInput) throws DukeException {
        String[] command;

        command = userInput.split(" ", 2);

        switch (command[0]) {
        case "todo":
            try {
                taskList.addTask(new Todo(command[1]));
            } catch (Exception e) {
                throw new DukeException("todo");
            }
            break;
        case "deadline":
            try {
                command = command[1].split("/by");
                taskList.addTask(new Deadline(command[0], command[1]));
            } catch (Exception e) {
                throw new DukeException("deadline");
            }
            break;
        case "event":
            try {
                command = command[1].split("/at");
                taskList.addTask(new Event(command[0], command[1]));
            } catch (Exception e) {
                throw new DukeException("event");
            }
            break;
        default:
            throw new DukeException("invalid command");
        }

        Ui.printAddTaskMessage(taskList);
    }

    private void userCompleteTask(String userInput) throws DukeException {
        int taskNumberCompleted;

        try {
            taskNumberCompleted = Integer.parseInt(userInput.replace("done", "").trim());
        } catch (Exception e) {
            throw new DukeException("done");
        }

        if (taskNumberCompleted > taskList.getTotalTask()) {
            throw new DukeException("invalid task action");
        }

        taskList.markTaskAsDone(taskNumberCompleted);

        Ui.printCompleteTaskMessage(taskNumberCompleted, taskList);
    }

    private void userViewTaskList() {
        Ui.printTaskListView(taskList);
    }

    private void userDeleteTask(String userInput) throws DukeException {
        int taskNumberDelete;

        try {
            taskNumberDelete = Integer.parseInt(userInput.replace("delete", "").trim());
        } catch (Exception e) {
            throw new DukeException("delete");
        }
        if (taskNumberDelete > taskList.getTotalTask()) {
            throw new DukeException("invalid task action");
        }

        Ui.printDeleteTaskMessage(taskNumberDelete, taskList);

        taskList.deleteTask(taskNumberDelete - 1); // - 1 to cater for index starting from 0
    }

    public void extractCommandFromStorage(String command) {
        String task = command.substring(1, 2);
        String isDone = command.substring(3, 6);
        String taskDescription = command.substring(7);

        switch (task) {
        case "T":
            taskList.addTask(new Todo(taskDescription));
            break;
        case "D":
            int indexEndOfDesc = taskDescription.indexOf(" (by: ");
            taskDescription= taskDescription.replace("(by: ", "");
            taskList.addTask(new Deadline(taskDescription.substring(0, indexEndOfDesc),
                    taskDescription.substring(indexEndOfDesc, taskDescription.length() - 1)));
            break;
        case "E":
            indexEndOfDesc = taskDescription.indexOf(" (at: ");
            taskDescription=taskDescription.replace("(at: ", "");
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
