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
        String[] list = new String[100];
        int i = 0;

        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (!line.equals("bye")){
            if (!line.equals("list")) {
                list[i] = Integer.toString(i + 1) + ". " + line;
                System.out.println("added: " + line);
                i++;
            } else {
                for (String listNum : Arrays.copyOf(list, i)){
                    System.out.println(listNum);
                }
            }
            line = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!\n");
    }
}
