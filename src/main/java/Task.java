import java.util.Arrays;

public class Task {
    protected String description;
    protected boolean isDone;

    private static int totalTask = 0;
    private static Task[] taskList = new Task[100];

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        totalTask++;        
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public static int getTotalTask() {
        return totalTask;
    }

    public String getDescription() {
        return description;
    }

    public void markAsDone() {
        this.isDone = true;
    }
}
