import java.util.Arrays;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________\n" +
                " Hello! I'm Duke\n" +
                " What can I do for you?\n");

        String line;
        String[] command;
        Task[] taskList = new Task[100];
        int taskListNumber = 0;
        int taskNumberCompleted;

        Scanner in = new Scanner(System.in);
        line = in.nextLine();

        while (!line.equals("bye")){

            switch (line.trim()){
            case "list":
                printTaskList(taskList);
                break;

            default:
                if(line.contains("done")){
                    //get the task number from user input
                    taskNumberCompleted = Integer.parseInt(line.substring(line.length() - 1));
                    taskList[taskNumberCompleted - 1].markAsDone(); // -1 to cater for index starting from 0

                    printDukeBorder();
                    System.out.println("Good work! I've marked this task as done: \n" +
                            "[" + taskList[taskNumberCompleted - 1].getStatusIcon() + "] " + taskList[taskNumberCompleted - 1].getDescription());
                } else {
                    command =  line.split(" ",2);
                    switch (command[0]){
                    case "todo":
                        taskList[taskListNumber] = new Todo(command[1]);
                        break;
                    case "deadline":
                        command = command[1].split("/by");
                        taskList[taskListNumber] = new Deadline(command[0], command[1]);
                        break;
                    case "event":
                        command = command[1].split("/at");
                        taskList[taskListNumber] = new Event(command[0], command[1]);
                        break;
                    }
                    printDukeBorder();
                    System.out.println("Got it. I've added this task:");
                    System.out.println(taskList[taskListNumber]);
                    System.out.println("Your total tasks: " + Task.getTotalTask());
                    taskListNumber++;
                }
            }

            line = in.nextLine();
        }
        
        printDukeBorder();
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public static void printTaskList(Task[] taskList){
        printDukeBorder();
        System.out.println("This is your list of task(s):");
        for (int i = 0; i < Task.getTotalTask(); i++){
            System.out.printf("%d." + taskList[i] + "\n", i + 1);
        }
    }

    public static void printDukeBorder(){
        System.out.println("............. DUKE CHATBOX ^^ ............");
    }
}
