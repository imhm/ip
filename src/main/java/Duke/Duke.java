package Duke;

public class Duke {

    public static void main(String[] args) {
        FileAccess.importData();
        printWelcomeMessage();
        CommandHandler.handleUserInput();
        printExitMessage();
        FileAccess.saveData();
    }

    private static void printWelcomeMessage() {
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

    private static void printExitMessage() {
        printDukeBorder(true);
        System.out.println("Bye. Hope to see you again soon!\n");
        printDukeBorder(false);
    }

    protected static void printDukeBorder(boolean top) {
        if (top) {
            System.out.println("............. DUKE CHATBOX ^^ ............");
        } else {
            System.out.println("..........................................");
        }
    }
}
