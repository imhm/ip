import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        printWelcomeMessage();
        handleUserInput();
        printExitMessage();
    }

    public static void handleUserInput() {
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine().trim();

        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) {
                userViewTaskList();
            } else {
                if (userInput.contains("done")) {
                    userCompleteTask(userInput);
                } else {
                    userAddTask(userInput);
                }
            }

            userInput = in.nextLine().trim();
        }
    }

    public static void userAddTask(String userInput) {
        String[] command;

        command = userInput.split(" ", 2);

        int taskListNumber = Task.getTotalTask();

        switch (command[0]) {
        case "todo":
            Task.setTaskList(new Todo(command[1]));
            break;
        case "deadline":
            command = command[1].split("/by");
            Task.setTaskList(new Deadline(command[0], command[1]));
            break;
        case "event":
            command = command[1].split("/at");
            Task.setTaskList(new Event(command[0], command[1]));
            break;
        default:
            break;
        }

        printDukeBorder(true);
        System.out.println("Got it. I've added this task:");
        System.out.println(Task.taskList[Task.getTotalTask() - 1]);
        System.out.println("Your total tasks: " + Task.getTotalTask());
        printDukeBorder(false);
    }

    public static void userCompleteTask(String userInput) {
        int taskNumberCompleted = Integer.parseInt(userInput.substring(userInput.length() - 1));
        Task.taskList[taskNumberCompleted - 1].markAsDone(); // - 1 to cater for index starting from 0

        printDukeBorder(true);
        System.out.println("Good work! I've marked this task as done:\n" + Task.taskList[taskNumberCompleted - 1]);
        printDukeBorder(false);
    }

    public static void userViewTaskList() {
        printDukeBorder(true);
        System.out.println("This is your list of task(s):");
        for (int i = 0; i < Task.getTotalTask(); i++) {
            System.out.printf("%d." + Task.taskList[i] + "\n", i + 1);
        }
        printDukeBorder(false);
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
}
