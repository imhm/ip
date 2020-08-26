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
        Task[] taskList = new Task[100];
        int i = 0;
        int taskNumber;

        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")){

            switch (line){

            case "list":
                printTaskList(taskList);
                break;

            default:
                if(line.contains("done")){
                    //get the task number from user input
                    taskNumber = Integer.parseInt(line.substring(line.length() - 1));
                    taskList[taskNumber - 1].markAsDone(); // -1 to cater for index start from 0
                } else {
                    taskList[i] = new Task(line);
                    i++;
                }
            }

            line = in.nextLine();
        }

        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public static void printTaskList(Task[] taskList){
        int i = 1;
        for (Task taskListNum : Arrays.copyOf(taskList, Task.getTotalTask())){
            System.out.printf("%d." + "[" + taskListNum.getStatusIcon() + "] " + taskListNum.getDescription() + "\n", i);
            i++;
        }
    }
}
